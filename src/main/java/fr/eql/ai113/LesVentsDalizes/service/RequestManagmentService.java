package fr.eql.ai113.LesVentsDalizes.service;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.RequestPerform;
import fr.eql.ai113.LesVentsDalizes.entity.Survey;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentCustomerException;

public interface RequestManagmentService {

    RequestPerform applyingForPerformance(RequestPerform requestPerform) throws NonExistentCustomerException;


    Customer retrieveCustomerById(Long id) throws NonExistentCustomerException;


}
