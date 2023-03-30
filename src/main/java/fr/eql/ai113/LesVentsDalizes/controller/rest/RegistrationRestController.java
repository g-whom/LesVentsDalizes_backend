package fr.eql.ai113.LesVentsDalizes.controller.rest;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
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
        Set<ConstraintViolation<Address>> violations2 = validator1.validate(customer.getAddress());


        //WIP : champs du client | After traiter champs de l'adresse ?!
        if (!violations.isEmpty() ||  !violations2.isEmpty()){
            logger.info("au moins 1 violation detectée");
            //liste des violations trouvées
            List<String> erros = new ArrayList<>();
            for (ConstraintViolation<Customer> violation : violations) {
                String errorMessage = violation.getPropertyPath() + ": " + violation.getMessage();
                erros.add(errorMessage);
            }
            for(ConstraintViolation<Address> violation2 : violations2){
                String errorMessageAdress = violation2.getPropertyPath()+ ": " + violation2.getMessage();
                erros.add(errorMessageAdress);
            }
            return ResponseEntity.badRequest().body(erros);
        }

        if(customer == null) {
            logger.info("La creation du nouveau client ne peut aboutir 'probleme de données' ");
            return ResponseEntity.badRequest().body("La creation du nouveau client ne peut aboutir 'probleme de données' ");
        }

        logger.info("Information du futur client semble ok "+customer.getAddress().toString());

        Address addressWIP = customer.getAddress();

        if (registrationService.checkIfAddressAlreadyUsed(addressWIP)!=null){
            addressWIP = registrationService.checkIfAddressAlreadyUsed(addressWIP);

        }
        Address addressCustomerValidate = registrationService.createAddresseCustomer(addressWIP);

        logger.info("VERIFION =>>>>>>>>>>>>>>>>> : "+addressCustomerValidate.toString());
        customer.setAddresse(addressCustomerValidate);
        customer.setSubscriptionDate(LocalDate.now());

        logger.info("SHOW THE CUSTOMER INFO :: \r\n"+ customer.toString());
        return ResponseEntity.ok(registrationService.createCustomerAccount(customer));

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
