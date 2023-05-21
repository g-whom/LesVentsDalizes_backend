package fr.eql.ai113.LesVentsDalizes.service.impl;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.Role;
import fr.eql.ai113.LesVentsDalizes.entity.dto.AuthRequest;
import fr.eql.ai113.LesVentsDalizes.entity.dto.CustomerDto;
import fr.eql.ai113.LesVentsDalizes.exceptions.AccountExistsException;
import fr.eql.ai113.LesVentsDalizes.exceptions.ClassCastLongException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentRoleException;
import fr.eql.ai113.LesVentsDalizes.repository.AddressDao;
import fr.eql.ai113.LesVentsDalizes.repository.CustomerDao;
import fr.eql.ai113.LesVentsDalizes.repository.RoleDao;
import fr.eql.ai113.LesVentsDalizes.service.RegistrationService;
import fr.eql.ai113.LesVentsDalizes.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@Configuration
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(getClass());

    /** Injecté par le setter */
    private CustomerDao customerDao;
    /** Injecté par le setter */
    private AuthenticationManager authenticationManager;
    private RegistrationService registrationService;

    private final String signingKey;

    private RoleDao roleDao;
    private AddressDao addressDao;

    /// CONSTRUCTOR ///


    public UserServiceImpl(@Value("${jwt.signing.key}") String signingKey) {
        this.signingKey = signingKey;
    }

    /// METHODS ///
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /// @OVERIDE ///

        @Override
    public Authentication authenticate(AuthRequest authRequest) throws AuthenticationException {
        Authentication authentication = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
        return authenticationManager.authenticate(authentication);
    }

    /**
     * <h3>This method allows to register a Customer from the CustomerDto taken in parameter.</h3>
     *
     * @param customerDto
     * @return
     * @throws AccountExistsException
     * @throws NonExistentRoleException
     * @throws ClassCastLongException
     *
     * @Author J.VENT
     */
    @Override
    public UserDetails save(CustomerDto customerDto) throws
            AccountExistsException,
            NonExistentRoleException,
            ClassCastLongException{

        if (customerDao.findCustomerByUsername(customerDto.getUsername()) != null) {
            throw new AccountExistsException();
        }

        //Get id address
        Address addressValidate = customerDto.getAddress();


        //verifie si l'adresse est déja dans le system
        if (registrationService.checkIfAddressAlreadyUsed(addressValidate) != null) {
            addressValidate = registrationService.checkIfAddressAlreadyUsed(customerDto.getAddress());
        }else {
            addressValidate= addressDao.save(addressValidate);
        }


        Customer owner = customerDto.convertCustomerDtoToCustomer();
        owner.setAddress(addressValidate);
        owner.setPassword(passwordEncoder().encode( customerDto.getPassword()));
        owner.setSubscriptionDate(LocalDate.now());

        //4L : ROLE_USER
        Collection<Role> roleCollectionValidate = feedCustomerDtoRole(customerDto, 4L);
        if (!roleCollectionValidate.isEmpty()){

            owner.setRoles(roleCollectionValidate);
        }

        customerDao.save(owner);
        return owner.convertCustomerToCustomerDtoWithoutPassword();
    }


    /**
     * This method will assign either roles detected in the client attributes or the default one
     *
     * @param customerDto
     * @param defaultRoleId
     *
     * @return - the collection of roles obtained
     * @throws NonExistentRoleException
     * @throws ClassCastLongException - if the expected type 'Long' is not found
     * @Author : J.VENT
     */
    private Collection<Role> feedCustomerDtoRole( CustomerDto customerDto, Long defaultRoleId)
            throws NonExistentRoleException, ClassCastLongException{

        if (!(defaultRoleId instanceof Long) ){
            logger.info("Le type attendu est Long pour : defaultRoleId neanmoins le type troubée est :"+
                    defaultRoleId.getClass().getSimpleName()+" !!");
            throw new ClassCastLongException("Une Erreur de typage détectée");
        }


        Collection<Role> roleCollectionValidate = new ArrayList<>();

        if (customerDto.getAuthorities().isEmpty()){
            //creation de la collection
            Collection<Role> roleCoellectionCustomer = new ArrayList<Role>();

            Optional<Role> roleCustomer = roleDao.findById(defaultRoleId);
            if (!roleCustomer.isPresent()){
                throw new NonExistentRoleException();
            }

            roleCoellectionCustomer.add(roleCustomer.get());
            customerDto.setRoles(roleCoellectionCustomer);

            // authRequest.setRoles(roleCoellectionCustomer);
            roleCollectionValidate.add(roleCustomer.get());
        }else{
            // gestion des roles
            Collection<Role> roleCollection = (Collection<Role>) customerDto.getAuthorities();

            // Obtention d'un itérateur pour la collection
            Iterator<Role> it = roleCollection.iterator();

            while (it.hasNext()) {
                Role element = it.next();

                Optional<Role> roleCustomer = roleDao.findById(element.getId());
                if (!roleCustomer.isPresent()){
                    throw new NonExistentRoleException();
                }
                Role roleValidate = roleCustomer.get();
                roleCollectionValidate.add( roleValidate);

            }
        }

        return roleCollectionValidate;
    }


    @Override
    public String generateJwtForUser(UserDetails user) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + 3600 * 1000);
        return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(now).setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, signingKey).compact();
    }




    @Override
    public UserDetails getUserFromJwt(String jwt) {
        String username = getUsernameFromToken(jwt);
         return loadUserByUsername(username);
    }

    @Override
    public Role retrieveRole(Long id) throws NonExistentRoleException{

       Optional<Role> roleTocheck = roleDao.findById(id) ;
       if(!roleTocheck.isPresent()){
           throw new NonExistentRoleException();
       }
        //return null;
        return roleTocheck.get();
    }

    private String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer owner = customerDao.findCustomerByUsername(username);
        if (owner == null) {
            throw new UsernameNotFoundException("Le propriétaire n'a pas été trouvé.");
        }
        return owner;
    }

    /// GETTERS ///
    /// SETTER ///


    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Autowired
    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
}
