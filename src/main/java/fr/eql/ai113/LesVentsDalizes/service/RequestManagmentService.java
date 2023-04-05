package fr.eql.ai113.LesVentsDalizes.service;

import fr.eql.ai113.LesVentsDalizes.entity.*;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentCustomerException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentEventException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentStatusPerformException;

public interface RequestManagmentService {

    RequestPerform applyingForPerformance(RequestPerform requestPerform)
            throws NonExistentCustomerException,
            NonExistentEventException,
            NonExistentStatusPerformException;


    Customer retrieveCustomerById(Long id) throws NonExistentCustomerException;

    Event retrieveEventById(Long id)throws NonExistentEventException;

    StatusRequestPerform retrieveStatusRequestPerformByID(Long id) throws NonExistentStatusPerformException;



    }
