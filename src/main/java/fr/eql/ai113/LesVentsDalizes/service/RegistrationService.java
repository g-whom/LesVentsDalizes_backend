package fr.eql.ai113.LesVentsDalizes.service;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.Member;
import fr.eql.ai113.LesVentsDalizes.entity.dto.CustomerDto;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentCustomerException;

/**
 * The service  layer responsible for the business logic of managing Customer records in the application
 */

public interface RegistrationService {




    Customer createCustomerAccount(Customer customer);

    //Customer createMemberAccount(Customer customer);

    Address createAddresseCustomer(Address address);

    Customer checkIfLoginAvailable(String login);
    Address checkIfAddressAlreadyUsed(Address address);

    Member registerNewMember(Member member);







    Customer findCustomerById(Long id);



}
