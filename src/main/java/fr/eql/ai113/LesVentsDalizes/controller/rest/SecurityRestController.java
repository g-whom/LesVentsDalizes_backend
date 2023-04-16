package fr.eql.ai113.LesVentsDalizes.controller.rest;

import fr.eql.ai113.LesVentsDalizes.entity.dto.AuthRequest;
import fr.eql.ai113.LesVentsDalizes.entity.dto.AuthResponse;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentRoleException;
import fr.eql.ai113.LesVentsDalizes.service.RegistrationService;
import fr.eql.ai113.LesVentsDalizes.exceptions.AccountExistsException;
import fr.eql.ai113.LesVentsDalizes.exceptions.UnauthorizedException;
import fr.eql.ai113.LesVentsDalizes.service.UserService;
import fr.eql.ai113.LesVentsDalizes.validators.CustomerValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Validator;


@RestController
@RequestMapping("security")
@CrossOrigin(origins = "${front.url}")
public class SecurityRestController {

    Logger logger = LoggerFactory.getLogger(getClass());
    /** Injecté par le setter */
    UserService userService;
    RegistrationService registrationService;
    CustomerValidator customerValidator;
    Validator validator;

   //WIP :  private HttpSessionCsrfTokenRepository csrfTokenRepository = new HttpSessionCsrfTokenRepository();

//http://localhost:8097/security/authorize


    @PostMapping("/authorize")
    public ResponseEntity<AuthResponse> authorize(@RequestBody AuthRequest requestDto) throws UnauthorizedException {
        Authentication authentication;
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\t\n\r\n");
        try {
            //authentication = userService.authenticate(requestDto.getUsername(), requestDto.getPassword());
            authentication = userService.authenticate(requestDto);
//            logger.info(authentication.getName().toString());
//            logger.info("verif ...");
//            logger.info(authentication.toString());
//            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\t\n\r\n");
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails owner = (UserDetails) authentication.getPrincipal();
            String token = userService.generateJwtForUser(owner);
            return ResponseEntity.ok(new AuthResponse(owner, token));


        } catch (AuthenticationException e) {
            logger.info("Erreur : "+e.getMessage());
            throw new UnauthorizedException();
        }
    }

    //http://localhost:8097/security/register
    @RequestMapping("/*")
    //@RolesAllowed("ROLE_GUEST")
    @PostMapping("/register")
    //ResponseEntity<AuthResponse>
    public ResponseEntity<?> register(@RequestBody AuthRequest requestDto) throws AccountExistsException, NonExistentRoleException {

        //////////////
        UserDetails owner = userService.save(requestDto);
        String token  = userService.generateJwtForUser(owner);
        return ResponseEntity.ok(new AuthResponse(owner, token));
    }


    //copie de sauvegarde : ResponseEntity<AuthResponse>
    /* Copie de sauvegarde

        @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest requestDto) throws AccountExistsException {

        //////////////

        /// UPDATE ///

        logger.info("\t\n\r >>>>  Depuis Register : "+requestDto.toString() +"\r\n");
        UserDetails owner = userService.save(requestDto.getUsername(), requestDto.getPassword());
        String token  = userService.generateJwtForUser(owner);
        return ResponseEntity.ok(new AuthResponse(owner, token));
    }


    * */

    /// Setters ///
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setCustomerValidator(CustomerValidator customerValidator) {
        this.customerValidator = customerValidator;
    }
    @Autowired
    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    @Autowired
    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
}
