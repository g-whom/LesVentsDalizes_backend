package fr.eql.ai113.LesVentsDalizes.controller.rest;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.dto.PasswordDto;
import fr.eql.ai113.LesVentsDalizes.exceptions.AddressExistException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentAddressException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentCustomerException;
import fr.eql.ai113.LesVentsDalizes.exceptions.ValidPasswordException;
import fr.eql.ai113.LesVentsDalizes.service.DataManagementCustomerService;
import fr.eql.ai113.LesVentsDalizes.service.RegistrationService;
import fr.eql.ai113.LesVentsDalizes.validators.PasswordValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customers")
@CrossOrigin(origins = "${front.url}")
public class DataManagmentCustomerRestController {
// http://localhost:8097/customers/
    Logger logger = LoggerFactory.getLogger(getClass());

    DataManagementCustomerService dataManagementCustomerService;
    RegistrationService registrationService;

    private PasswordValidator passwordValidator;

  //   Consultation des information du customer | member

    @GetMapping("/search/{idCustomer}/id")
    public ResponseEntity<?> retrieveCustomerById(@PathVariable Long idCustomer) throws NonExistentCustomerException {

        // Posstman: http://localhost:8097/customers/search/{idCustomer}/id

        logger.info("\t\r\n On est entré dans : retrieveCustomerByUsername (data...)");
        try {
            logger.info("\t\r\n On est dans le try ");
            Customer customerFind = dataManagementCustomerService.fetchCustomerById(idCustomer);
            return ResponseEntity.ok(customerFind);
        }catch (NonExistentCustomerException e){
            logger.info("Erreur :  Client "+e.getMessage());
            return ResponseEntity.badRequest().body("");
        }catch (Exception e){
            logger.info("Erreur : "+e.getMessage());
            return ResponseEntity.badRequest().body("");
        }
    }



    @GetMapping("/search/username/{usernameCustomer}")
    public ResponseEntity<?> retrieveCustomerByUsername(@PathVariable String usernameCustomer) throws NonExistentCustomerException {

        // Posstman: http://localhost:8097/customers/search/username/3

        try{
            Customer customerFound = dataManagementCustomerService.fetchCustomerByUsername(usernameCustomer);
            return ResponseEntity.ok(customerFound);
        }catch(NonExistentCustomerException e){
            logger.info("Customner ayant l'username : "+usernameCustomer+" n'existe pas");
            return ResponseEntity.badRequest().body("");
        }
    }


    @GetMapping("/search/all")
    public ResponseEntity<?> fetchAllCustomer(){

        // Posstman: http://localhost:8097/customers/search/all

        logger.info("on entre dans la méthode pour trouver tous les Customer");

        List<Customer> customerList = new ArrayList<>();
        try {
           logger.info("teston l'appel : dataManagementCustomerService.fetchAllCustomer() ...");
           customerList = dataManagementCustomerService.fetchAllCustomer();

           logger.info("que vaut cet appel ? "+ customerList.toString());
           return  ResponseEntity.ok(customerList);

        }catch (Exception e){

            return ResponseEntity.badRequest().body("Oups IL y a une exception !! " + e);
        }



    }

    // Modification des informations du customer | member


    /**
     * WIP : recuperer l'adresse d'un client ... prevoir update avec DTO !!
     * @param idCustomer
     * @return
     * @throws NonExistentCustomerException
     * @throws NonExistentAddressException
     */

    //http://localhost:8097/customers/address/customer/2
    @GetMapping("/address/customer/{idCustomer}")
    public ResponseEntity<?> fetchAddressCustomerFromIdCustomer(@PathVariable Long idCustomer)
            throws NonExistentCustomerException,
            NonExistentAddressException {
        // Posstman: http://localhost:8097/customers/

        logger.info("");

        try {
           Address addressFound = dataManagementCustomerService.getAddressCustomerFromIdCustomer(idCustomer);
           return ResponseEntity.ok(addressFound);
        }catch (NonExistentCustomerException e){
            logger.info("Erreur : Le client ayant l'id n'est pas référencé");
            return ResponseEntity.badRequest().body(""+e.getMessage());
        }catch (NonExistentAddressException e){
            logger.info("Erreur : L'addresse n'est pas présente dans le système");
            return ResponseEntity.badRequest().body(""+e.getMessage());

        }


    }

    /**
     * WIP: Retrouver une addresse depuis son Id
     * @param idAddress
     * @return
     */
    @GetMapping("/address/{idAddress}")
    public ResponseEntity<?> fetchAddressFromId(@PathVariable Long idAddress){

        // Posstman: http://localhost:8097/customers/address/{idAddress}


        try{
            Address addressFound = dataManagementCustomerService.getAddressById(idAddress);
            return ResponseEntity.ok(addressFound);

        }catch(NonExistentAddressException e){
            logger.info("Erreur : L'addresse n'est pas présente dans le système");
            return ResponseEntity.badRequest().body(""+e.getMessage());
        }catch (Exception e){
            logger.info("Erreur : lié probablement à la base de données [fetchAddressFromId] ");
            return ResponseEntity.badRequest().body("Une anomalie s'est produite...");
        }
    }


    //suppréssion du compte du customer | member

    // WIP
    @PutMapping("/new/address/customer/{idCustomer}")
    public ResponseEntity<?> updateAddressCustomer(@PathVariable Long idCustomer, @RequestBody Address address){

        // Posstman: http://localhost:8097/customers/new/address/customer/{idCustomer}


        /*

    "address" :
            {

                "numberRoad": "90",
                "road":"rrue de Moscou",
                "zipCode":"94900",
                "city":"PUTIN",
                "country": "France"
            }
         */
        try {
           Address addressUpdate =  dataManagementCustomerService.updateAddressCustomer(address, idCustomer);
            return ResponseEntity.ok(addressUpdate);
        }catch (NonExistentCustomerException e){
            logger.info("Erreur : l'id du client n'est pas référencer dans le système\");");
            return ResponseEntity.badRequest().body(""+e);
        }catch (AddressExistException e){
            logger.info("Errreur : Aucun champs de l'addresse n'a été modifié");
            return ResponseEntity.badRequest().body(""+e);
        }catch (Exception e){
            logger.info("Errreur :anomalie détecteée (surement en base de données)");
            return ResponseEntity.badRequest().body(""+e);
        }


    }

    @PostMapping ("/update/data/customer")
    public ResponseEntity<?> updateDataCustomer(@RequestBody Customer customer) throws NonExistentCustomerException{
        // Posstman: http://localhost:8097/customers/update/data/customer
        /*
        http://localhost:8097/customers/update/data/customer

        {
            "id":1,
            "name":"Michel",
                "surname":"jackson",
                "birthdate":"1973-02-01",
                "phoneNumber" : "08343435",
                "qubscriptionDate" : null
        }
        */
        try {
            Customer customerUpdate = dataManagementCustomerService.updateCustomerData(customer);
            return ResponseEntity.ok(customerUpdate);
        }catch (NonExistentCustomerException e){
            logger.info("Une anomalie détectée, le client ayant l'id n'est pas reconnu par le System");
            return ResponseEntity.badRequest().body(""+e);
        }catch (Exception e){
            logger.info("Une anomalie détectée .. !!!");
            return ResponseEntity.badRequest().body(""+e);
        }
    }

    //WIP :
    @PostMapping("update/password/customer")
    public ResponseEntity<?> updatePasswordCustomer(@RequestBody PasswordDto passwordDto,  BindingResult result) {
        /*
        Posstman:       http://localhost:8097/customers/update/password/customer

        ID  : jeje@whum.com
        OLD : eR3#£_\éé
        NEM : T|oà46..3R

       {
            "username" : "audrey@cop.com",
            "password" : "eR3#£_\éé",
            "passwordNew" :"T|oà46..3R",
            "passwordNewBis" :"T|oà46.."
        }



       */

        passwordValidator.validate(passwordDto,result);
        if(result.hasErrors()){
            List<String> errors = new ArrayList<>();
            for (ObjectError error : result.getAllErrors()) {
                errors.add(error.getDefaultMessage()+"\r");
            }
            logger.info(" Le nouveaux mot de passe n'est pas valide : "+errors);
           // throw new ValidPasswordException( );
            return ResponseEntity.badRequest().body(""+errors);
        }


        try{
            Customer customerPasswordUpdate = dataManagementCustomerService.updatePasswordCustomer(passwordDto);
            return ResponseEntity.ok(customerPasswordUpdate);

        }catch (NonExistentCustomerException e){
            logger.info("LE client {} n'est pas présent dans le systeme");
            return ResponseEntity.badRequest().body("");
        }
        catch(Exception e){
            logger.info("Une anomalie s'est produite.. "+e);
            return ResponseEntity.badRequest().body(""+e);
        }
    }




    /// SETTERS ///

    @Autowired
    public void setDataManagementCustomerService(DataManagementCustomerService dataManagementCustomerService) {
        this.dataManagementCustomerService = dataManagementCustomerService;
    }

    @Autowired
    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Autowired
    public void setPasswordValidator(PasswordValidator passwordValidator) {
        this.passwordValidator = passwordValidator;
    }
}
