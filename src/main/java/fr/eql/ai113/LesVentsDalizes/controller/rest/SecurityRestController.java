package fr.eql.ai113.LesVentsDalizes.controller.rest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.eql.ai113.LesVentsDalizes.deserializer.LocalDateDeserializer;
import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.dto.AuthRequest;
import fr.eql.ai113.LesVentsDalizes.entity.dto.AuthResponse;
import fr.eql.ai113.LesVentsDalizes.entity.dto.CustomerDto;
import fr.eql.ai113.LesVentsDalizes.exceptions.*;
import fr.eql.ai113.LesVentsDalizes.service.RegistrationService;
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
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Validator;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;


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


    /**
     * <h3>This method allows a user to authenticate himself..</h3>
     * <p>If the authentication is successful an authentication and authorization token will be assigned to him and his roles</p>
     * @param requestDto
     * @return
     * @throws UnauthorizedException
     *
     * @Author: J.VENT
     */
    @PostMapping("/authorize")
    public ResponseEntity<AuthResponse> authorize(@RequestBody AuthRequest requestDto) throws UnauthorizedException {
        Authentication authentication;
        try {

            authentication = userService.authenticate(requestDto);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails owner = (UserDetails) authentication.getPrincipal();
            String token = userService.generateJwtForUser(owner);

            owner = ((Customer) owner).convertCustomerToCustomerConnectDto();
            return ResponseEntity.ok(new AuthResponse(owner, token));


        } catch (AuthenticationException e) {

            throw new UnauthorizedException();
        }
    }


    /**
     * <h3>this method allows to register a user in the system provided that his data are valid</h3>
     *
     * @param customerDto
     * @param result
     * @return
     * @throws AccountExistsException
     * @throws NonExistentRoleException
     *
     * @author: J.VENT
     *
     */
    @RequestMapping("/*")
    //@RolesAllowed("ROLE_GUEST")
    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody @JsonDeserialize(using = LocalDateDeserializer.class)
            CustomerDto customerDto, BindingResult result)
            throws
            AccountExistsException,
            NonExistentRoleException {

       /*
       POSTMAN : http://localhost:8097/security/register

       {
            "name":"genasis",
            "surname":"ot",
            "birthdate":"1980-04-19",
            "username":"jeromeo@vetnort.fr",
            "phoneNumber" : "06834023",
            "qubscriptionDate" : null,
            "password":"bU||3t_ô",
                "address" :
                        {
                            "numberRoad": "9",
                            "road":"rossigpnopoyol_ok",
                            "zipCode":"74403",
                            "city":"@",
                            "country": "France"
                        },
            "roles":[
                {"id":1 },
                {"id":4 }
            ]
        }
       * */

        try{
            customerValidator.validate(customerDto, result);
            if(result.hasErrors()){
                List<String> errors = new ArrayList<>();
                for (ObjectError error : result.getAllErrors()) {
                    errors.add(error.getDefaultMessage()+"\r");
                }
                logger.info(" Le customerDtp  est invalide : "+errors);
                return ResponseEntity.badRequest().body(""+errors);
            }

            UserDetails owner = userService.save(customerDto);
            String token  = userService.generateJwtForUser(owner);
            return ResponseEntity.ok("");//new AuthResponse(owner, token));
        }catch(DateTimeParseException e){
            logger.info("Une erreur  dzetectée >> le format de date non valide :" +
                    " il faut se format YYY-MM-DD et non :  "+customerDto.getBirthdate());
            return ResponseEntity.badRequest().body("Une annomalie detectée");

        }catch(InvalidDateFormatException e){
            logger.info("Format non valide pour la date de naissance Bithdate");
            return ResponseEntity.badRequest().body("Une annomalie detectée");
        } catch(ClassCastLongException e){
            logger.info("Une erreur de typage dzetectée >> prevoir la redirection ASAP ");
            return ResponseEntity.badRequest().body("Une annomalie detectée");
        }
    }




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
