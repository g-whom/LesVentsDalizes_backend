package fr.eql.ai113.LesVentsDalizes.controller.rest;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.Member;
import fr.eql.ai113.LesVentsDalizes.service.RegistrationService;
import fr.eql.ai113.LesVentsDalizes.validators.CustomerValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;


import javax.validation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin(origins = "http://localhost:3006")
@RequestMapping("regisration")
public class RegistrationRestController  {

    Logger logger = LoggerFactory.getLogger(getClass());


    //injecté par le setter
    RegistrationService registrationService;


    CustomerValidator customerValidator;
    Validator validator;

    /**
     * WIP : HTTP + Javadaoc + controle
     * @param id
     * @return
     */
    @GetMapping("/customer/{id}")
    public Customer retrieveCustomerById(@PathVariable Long id){

        //Postman : http://localhost:8097/regisration/customer/1

        return registrationService.findCustomerById(id);
    }

    /**
     * WIP : HTTP + Javadaoc + controle
     * @param email
     * @return
     */
    @GetMapping("/login/{email}")
    public Customer checkIfLoginAvailable(@PathVariable String email) {
        return registrationService.checkIfLoginAvailable(email) ;
    }

    /**
     * WIP : Controle + java doc
     * @param member
     * @return
     */
    @PostMapping("/member/new")
    public Member createMemberAccount(@RequestBody Member member){

        /*
            dans postan:

            http://localhost:8097/regisration/member/new

            {

                "name": "tony",
                "surname" : "yoka",
                "birthdate" : "1987-12-03",
                "subscriptionDate" : null,
                "email" : "tony@yroka.com",
                "password" : "caporal",
                "phoneNumber" :"07234(é",
                "accountClosingDate" : null,
                "address" :
                        {
                            "id":"23",
                            "numberRoad": "94",
                            "road":"cJoisy ",
                            "zipCode":"94413",
                            "city":"VAl",
                            "country": "France"
                        },
                "dateOfMembership":"2023-01-04",
                "registrationFee":50.0,
                "upToDate":true,
                "customerBecomingMember":false,
                "annualFeesList":null
            }

         */
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
        System.out.println(member.getName());
        System.out.println(member.getAddress().toString());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
        return registrationService.registerNewMember(member);

    }

    /**
     *
     * @param customer
     * @return
     */
    @PostMapping("/customer/new")
    public ResponseEntity< ? > createCustomerAccount(@RequestBody @Valid Customer customer, BindingResult result)  {

        /*
         dans Postman : http://localhost:8097/regisration/customer/new

         {
            "id": 47767377,
            "name": "jay",
            "surname" : "Z",
            "birthdate" : "1987-12-03",
            "subscriptionDate" : null,
            "email" : "jej2e@whum.com",
            "password" : "caporal",
            "phoneNumber" :"07234(é",
            "accountClosingDate" : null,
            "address" :
            {
                "id":"24",
                "numberRoad": "93",
                "road":"cJeoeisy ",
                "zipCode":"94413",
                "city":"VAl",
                "country": "France"
            }
         }

         */

        if (registrationService.checkIfLoginAvailable(customer.getEmail() )!=null ){
            return ResponseEntity.badRequest().body("il semblerait que ce compte soit déjà dans notre systeme");
        }


//        customerValidator.validate(customer,result);
//        if(result.hasErrors()){
//            List<String> errors = new ArrayList<>();
//            for (ObjectError error : result.getAllErrors()) {
//                errors.add(error.getDefaultMessage());
//            }
//            logger.info(" Les données du client ne sont pas valide : "+errors);
//            return ResponseEntity.badRequest().body("L'enregistrement du clietn à échouée");
//        }

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



    //WIP



    /// SETTER ///
    @Autowired
    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Autowired
    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    @Autowired
    public void setCustomerValidator(CustomerValidator customerValidator) {
        this.customerValidator = customerValidator;
    }
}
