package fr.eql.ai113.LesVentsDalizes.service;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * The service  layer responsible for the business logic of managing Customer records in the application
 */

public interface RegistrationService {


    Customer checkIfLoginAvailable(String login);

    Customer createAccount(Customer customer);

    Customer findCustomerById(int id);



}
