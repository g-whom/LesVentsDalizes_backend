package fr.eql.ai113.LesVentsDalizes.service;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.Event;
import fr.eql.ai113.LesVentsDalizes.entity.RequestPerform;
import fr.eql.ai113.LesVentsDalizes.entity.Survey;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentCustomerException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentEventException;

public interface RequestManagmentService {

    RequestPerform applyingForPerformance(RequestPerform requestPerform) throws NonExistentCustomerException,NonExistentEventException ;


    Customer retrieveCustomerById(Long id) throws NonExistentCustomerException;

    public Event retrieveEventById(Long id)throws NonExistentEventException;


}
