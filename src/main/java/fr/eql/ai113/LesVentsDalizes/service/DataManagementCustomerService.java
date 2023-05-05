package fr.eql.ai113.LesVentsDalizes.service;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.dto.PasswordDto;
import fr.eql.ai113.LesVentsDalizes.entity.dto.UsernameDto;
import fr.eql.ai113.LesVentsDalizes.exceptions.AddressExistException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentAddressException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentCustomerException;

import java.util.List;

public interface DataManagementCustomerService {


    /**
     * this methode permet de mettre à jour les informations d'un client
     * @param customer
     * @return
     * @throws NonExistentCustomerException
     */
    Customer updateCustomerData(Customer customer) throws NonExistentCustomerException, Exception;


    Customer fetchCustomerById(Long idCustomer) throws NonExistentCustomerException;
    Customer fetchCustomerByUsername(String username) throws NonExistentCustomerException;

    Address getAddressCustomerFromIdCustomer(Long idCustomer) throws NonExistentCustomerException, NonExistentAddressException;

    Address getAddressById(Long idAddress) throws NonExistentAddressException;


    //WIP
    Customer updateDataCustomer(Customer customer) throws NonExistentCustomerException, Exception;

//    Customer updateUsernameCustomer(String oldUsername, String newUsername);
//    Customer updatePAsswordCustomer(Long idCustomer, String oldPassword, String newPassword; String newPassworBis)

    List<Customer> fetchAllCustomer();

    //-----------
    //
    Address updateAddressCustomer(Address address, Long idCustomer)
            throws NonExistentCustomerException,
            AddressExistException,
            Exception;


    Customer updatePasswordCustomer(PasswordDto passwordDto) throws NonExistentCustomerException, Exception;

    Customer updateCustomerUsername(UsernameDto usernameDto) throws NonExistentCustomerException, Exception;

}
