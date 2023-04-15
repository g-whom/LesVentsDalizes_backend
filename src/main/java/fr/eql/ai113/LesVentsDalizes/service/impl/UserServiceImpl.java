package fr.eql.ai113.LesVentsDalizes.service.impl;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.dto.AuthRequest;
import fr.eql.ai113.LesVentsDalizes.exceptions.AccountExistsException;
import fr.eql.ai113.LesVentsDalizes.repository.CustomerDao;
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
import java.util.Date;

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
        Authentication authentication = new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword());
        logger.info(authentication.toString());
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>\r\n");
        return authenticationManager.authenticate(authentication);
    }

    @Override
    public UserDetails save(AuthRequest authRequest) throws AccountExistsException {
                //if (ownerDao.findByLogin(username) != null) {
        if (customerDao.findCustomerByEmail(authRequest.getEmail()) != null) {
            throw new AccountExistsException();
        }

        //Get id address
        Address addressValidate = authRequest.getAddress();
        logger.info("Affichons l'adresse ? "+authRequest.getAddress().toString());

        if (registrationService.checkIfAddressAlreadyUsed(addressValidate)!=null){
            addressValidate = registrationService.checkIfAddressAlreadyUsed(addressValidate);

        }
        Address addressCustomerValidate = registrationService.createAddresseCustomer(addressValidate);

        logger.info("VERIFION => l'adresse recupéee >>>>>>>>>>>>>>>> : "+addressCustomerValidate.toString());

//        authRequest.setAddress(addressCustomerValidate);
//        authRequest.setSubscriptionDate(LocalDate.now());
//        authRequest.setAddress_id(addressValidate.getId());



        logger.info(" Afffiche : "+authRequest.getName()+"\r\n .....");
        Customer owner = new Customer();
        owner.setName(authRequest.getName());
        owner.setSurname(authRequest.getSurname());
        owner.setPhoneNumber(authRequest.getPhoneNumber());
        owner.setPassword( passwordEncoder().encode(  authRequest.getPassword() )  );
        owner.setSubscriptionDate(authRequest.getSubscriptionDate());
        owner.setEmail(authRequest.getEmail());
        owner.setBirthdate(authRequest.getBirthdate());
        owner.setAddress(addressValidate);
        owner.setSubscriptionDate(LocalDate.now());


        //owner.setAccountClosingDate(authRequest.getAccountClosingDate());
       // owner.setAddresse(authRequest.getAddress());


        //owner.getAddress(authRequest.getAddress());

        customerDao.save(owner); // ownerDao.save(owner);
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

    @Override
    public UserDetails getUserFromJwt(String jwt) {
        String username = getUsernameFromToken(jwt);
        return loadUserByUsername(username);
    }

    private String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Owner owner = ownerDao.findByLogin(username);
        Customer owner = customerDao.findCustomerByEmail(username);
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
}
