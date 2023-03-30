package fr.eql.ai113.LesVentsDalizes.service.impl;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.repository.AddressDao;
import fr.eql.ai113.LesVentsDalizes.repository.CustomerDao;
import fr.eql.ai113.LesVentsDalizes.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    //injecté par le setter
    private CustomerDao customerDao;

    //injecté par le setter
    private AddressDao addressDao;

    @Override
    public Customer checkIfLoginAvailable(String email) {
       // return  customerDao.existsByEmail(email);
        //return false;
        //return customerDao.existsByEmail(email) == null ? false : true;
        return customerDao.findCustomerByEmail(email);
    }

    @Override
    public Customer createCustomerAccount(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public Address createAddresseCustomer(Address address) {

        return addressDao.save(address);
    }

//    @Override
//    public Address checkIfAddressAlreadyUsed(Address address) {
//        //EN COURS
//        return addressDao.findPostalAddress(address);
//    }

    @Override
    public Address checkIfAddressAlreadyUsed(Address address) {
        //EN COURS
        return addressDao.findAddressByNumberRoadAndRoadAndCityAndCountryAndZipCode(
                address.getNumberRoad(),
                address.getRoad(),
                address.getCity(),
                address.getCountry(),
                address.getZipCode());
    }




    @Override
    public Customer findCustomerById(int id) {
        return customerDao.findCustomerById(id);
    }


    /// SETTER ///
    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Autowired
    public void setAddresseDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
}
