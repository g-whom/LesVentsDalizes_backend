package fr.eql.ai113.LesVentsDalizes.controller.rest;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("regisration")
public class RegistrationRestController  {

    //injecté par le setter
    RegistrationService registrationService;

    @GetMapping("/customer/{id}")
    public Customer retrieveCustomerById(@PathVariable int id){
        return registrationService.findCustomerById(id);
    }

    ////
    @GetMapping("/{email}")
    public Customer checkIfLoginAvailable(@PathVariable String email) {
        return registrationService.checkIfLoginAvailable(email) ;
    }


    public Customer createAccount(Customer customer) {
        return null;
    }


    /// SETTER ///
    @Autowired
    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
}
