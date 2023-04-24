package fr.eql.ai113.LesVentsDalizes.service.impl;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.Role;
import fr.eql.ai113.LesVentsDalizes.entity.dto.AuthRequest;
import fr.eql.ai113.LesVentsDalizes.exceptions.AccountExistsException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentRoleException;
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


//    @Override
//    public Authentication authenticate(String username, String password) throws AuthenticationException {
//        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
//        logger.info(authentication.toString());
//        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>\r\n");
//        return authenticationManager.authenticate(authentication);
//    }

        @Override
    public Authentication authenticate(AuthRequest authRequest) throws AuthenticationException {
        Authentication authentication = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
        logger.info(authentication.toString());
        logger.info(">>>>>>>>>>authenticate>>(doit retourner la valeur Authentication)>>>>>>>>>>>>>>\r\n");
        return authenticationManager.authenticate(authentication);
    }

    @Override
//    public UserDetails save(AuthRequest authRequest) throws AccountExistsException, NonExistentRoleException {
    public UserDetails save(Customer customer) throws AccountExistsException, NonExistentRoleException {


        logger.info("In [UserServiceImple > save] customer ? "+customer.toString());
        //if (ownerDao.findByLogin(username) != null) {
        if (customerDao.findCustomerByUsername(customer.getUsername()) != null) {
            throw new AccountExistsException();
        }

        //Get id address
        Address addressValidate = customer.getAddress();
        logger.info("Affichons l'adresse ? " + customer.getAddress().toString());

        if (registrationService.checkIfAddressAlreadyUsed(addressValidate) != null) {
            addressValidate = registrationService.checkIfAddressAlreadyUsed(addressValidate);
            logger.info("voici l'adresse qui doit etre ajoutéee : "+addressValidate.toString());

        }
        Address addressCustomerValidate = registrationService.createAddresseCustomer(addressValidate);

        logger.info("VERIFION => l'adresse recupéee >>>>>>>>>>>>>>>> : " + addressCustomerValidate.toString());

//        authRequest.setAddress(addressCustomerValidate);
//        authRequest.setSubscriptionDate(LocalDate.now());
//        authRequest.setAddress_id(addressValidate.getId());


        logger.info(" Afffiche le nom: " + customer.getName() + "\r\n .....");
        logger.info(" Afffiche le username: " + customer.getUsername() + "\r\n .....");
        logger.info(" Afffiche le password : " + customer.getPassword() + "\r\n .....");
        Customer owner = new Customer();
        owner.setName(customer.getName());
        owner.setSurname(customer.getSurname());
        owner.setPhoneNumber(customer.getPhoneNumber());

        owner.setPassword(passwordEncoder().encode(customer.getPassword()));
        owner.setSubscriptionDate(customer.getSubscriptionDate());
        owner.setUsername(customer.getUsername());
        owner.setBirthdate(customer.getBirthdate());
        owner.setAddress(addressValidate);
        owner.setSubscriptionDate(LocalDate.now());

        Collection<Role> roleCollectionValidate = new ArrayList<>();

        if (customer.getAuthorities().isEmpty()){// authRequest.getRoles().isEmpty()) {
            logger.info("PAs de ROLE TROUVE.. On S'EN Occupe.. :\t\r\n");
            //creation de la collection
            Collection<Role> roleCoellectionCustomer = new ArrayList<Role>();//new Role(3L);

            // update => recuperation
            //Role roleCustomer = new Role(3L);
            //4 : ROLE_USER
            Optional<Role> roleCustomer = roleDao.findById(4L);
            if (!roleCustomer.isPresent()){
                throw new NonExistentRoleException();
            }
            roleCoellectionCustomer.add(roleCustomer.get());
            customer.setRoles(roleCoellectionCustomer);
            // authRequest.setRoles(roleCoellectionCustomer);
            roleCollectionValidate.add(roleCustomer.get());
        }else{
            // gestion des roles
            Collection<Role> roleCollection = (Collection<Role>) customer.getAuthorities(); // authRequest.getRoles();

            // Obtention d'un itérateur pour la collection
            Iterator<Role> it = roleCollection.iterator();


            // Utilisation de l'itérateur pour parcourir la collection
            logger.info("AFFICHONS LES ROLES TROUVES :\t\r\n");
            logger.info("il y en a normalement : " +customer.getAuthorities().size()); // authRequest.getRoles().size());
            while (it.hasNext()) {
                Role element = it.next();
                //saving...
                logger.info("un role detecté, voila son ID >> : " + element.toString());

                logger.info("essayons de le recuperer franchement / ");

                Optional<Role> roleCustomer = roleDao.findById(element.getId());
                if (!roleCustomer.isPresent()){
                    throw new NonExistentRoleException();
                }
                Role roleValidate = roleCustomer.get();
                logger.info("voila le role recupeéré : "+roleValidate.toString());
                logger.info("il est donc ajouté à la collection ");
                roleCollectionValidate.add( roleValidate);

            }
        }
        if (!roleCollectionValidate.isEmpty()){
            logger.info("Ajout des roles mis a jout pour le custimer ...");
            owner.setRoles(roleCollectionValidate);
        }

        logger.info(" avant inzertuin en base quelles intformation avaons nous pour le customer ? : "+owner.toString() );
        customerDao.save(owner); // ownerDao.save(owner);
        logger.info(" le client apres insert supposé OK  :  "+owner.toString());
       // customerDao.save(owner); // ownerDao.save(owner);
        return owner;
    }
//
//    @Override
//    public UserDetails save(String username, String password) throws AccountExistsException {
//        //if (ownerDao.findByLogin(username) != null) {
//        if (customerDao.findCustomerByEmail(username) != null) {
//            throw new AccountExistsException();
//        }
//        Customer owner = new Customer();
//        owner.setEmail(username);//owner.setLogin(username);
//        owner.setPassword(passwordEncoder().encode(password));
//        customerDao.save(owner); // ownerDao.save(owner);
//        return owner;
//    }

//    @Override
//    public String generateJwtForUser(UserDetails user) {
//        Date now = new Date();
//        Date expirationDate = new Date(now.getTime() + 3600 * 1000);
//        return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(now).setExpiration(expirationDate)
//                .signWith(SignatureAlgorithm.HS512, signingKey).compact();
//    }
    @Override
    public String generateJwtForUser(UserDetails user) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + 3600 * 1000);
        return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(now).setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, signingKey).compact();
    }

    // ??


    @Override
    public UserDetails getUserFromJwt(String jwt) {
        logger.info(">>on  entre  dans [UserServiceImpl > getUserFromJwt]");
        String username = getUsernameFromToken(jwt);

       // String email = getUsernameFromToken(jwt);
      //  logger.info(">> [UserServiceImpl > getUserFromJwt] recuêration du mail : "+email);
        logger.info(">> [UserServiceImpl > getUserFromJwt] recuêration du mail : "+username);

//        return loadUserByUsername(email);
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
        //Owner owner = ownerDao.findByLogin(username);
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
}
