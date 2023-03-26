package fr.eql.ai113.LesVentsDalizes.controller.rest;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("regisration")
public class RegistrationRestController  {

    Logger logger = LoggerFactory.getLogger(getClass());


    //injecté par le setter
    RegistrationService registrationService;


    Validator validator;

    @GetMapping("/customer/{id}")
    public Customer retrieveCustomerById(@PathVariable int id){
        return registrationService.findCustomerById(id);
    }

    ////
    @GetMapping("/{email}")
    public Customer checkIfLoginAvailable(@PathVariable String email) {
        return registrationService.checkIfLoginAvailable(email) ;
    }

    /**
     *
     * @param customer
     * @return
     */
    @PostMapping("/customer/new")
    public ResponseEntity< ? > createCustomerAccount(@RequestBody Customer customer)  {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator1 = factory.getValidator();

        Set<ConstraintViolation<Customer>> violations = validator1.validate(customer);

        if (violations.isEmpty()){
            logger.info("pas de violation detectée");
            if (customer != null){
                logger.info("succes pour la création d'un nouveau Client");
                customer.setSubscriptionDate(LocalDate.now());
                return ResponseEntity.ok(registrationService.createCustomerAccount(customer));
            }
            logger.info("creation du nouveau client échouée");
            return ResponseEntity.badRequest().body("La création du client à échouée");

        }else{
            logger.info("au moins 1 violation detectée");
            //liste des violations trouvées
            List<String> erros = new ArrayList<>();
            for(ConstraintViolation<Customer> violation : violations){
                String errorMessage = violation.getPropertyPath()+ ": "+violation.getMessage();
                erros.add(errorMessage);
            }
        return ResponseEntity.badRequest().body(erros);
        }

    }


    /// SETTER ///
    @Autowired
    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Autowired
    public void setValidator(Validator validator) {
        this.validator = validator;
    }
}
