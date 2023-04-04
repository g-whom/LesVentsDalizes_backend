package fr.eql.ai113.LesVentsDalizes.service;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.Member;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentCustomerException;

/**
 * The service  layer responsible for the business logic of managing Customer records in the application
 */

public interface RegistrationService {


    Customer checkIfLoginAvailable(String login);

    Customer createCustomerAccount(Customer customer);

    Member registerNewMember(Member member);

    Address createAddresseCustomer(Address address);

   Address checkIfAddressAlreadyUsed(Address address);

    Customer findCustomerById(Long id);



}
