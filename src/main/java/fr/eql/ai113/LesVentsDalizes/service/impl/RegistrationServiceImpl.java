package fr.eql.ai113.LesVentsDalizes.service.impl;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.repository.CustomerDao;
import fr.eql.ai113.LesVentsDalizes.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    //injecté par le setter
    private CustomerDao customerDao;

    @Override
    public Customer checkIfLoginAvailable(String email) {
       // return  customerDao.existsByEmail(email);
        //return false;
        //return customerDao.existsByEmail(email) == null ? false : true;
        return customerDao.findCustomerByEmail(email);
    }

    @Override
    public Customer createCustomerAccount(Customer customer) {
        //return null;
        return customerDao.save(customer);
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


}
