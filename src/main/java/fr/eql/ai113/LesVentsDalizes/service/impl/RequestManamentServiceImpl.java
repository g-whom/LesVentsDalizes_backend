package fr.eql.ai113.LesVentsDalizes.service.impl;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.Event;
import fr.eql.ai113.LesVentsDalizes.entity.RequestPerform;
import fr.eql.ai113.LesVentsDalizes.entity.StatusRequestPerform;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentCustomerException;
import fr.eql.ai113.LesVentsDalizes.repository.CustomerDao;
import fr.eql.ai113.LesVentsDalizes.repository.RequestPerformDao;
import fr.eql.ai113.LesVentsDalizes.service.RequestManagmentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class RequestManamentServiceImpl implements RequestManagmentService {

    //gestion des  loggers (via Log4j ?)
    Logger logger = LoggerFactory.getLogger(this.getClass());



    //injecté par le setter
    private RequestPerformDao requestPerformDao;
    private CustomerDao customerDao;



    //Retrouver un client





    //WIP en woute ...
    /*
    soit  on part du principe que seul l
     */
    @Override
    public RequestPerform applyingForPerformance(RequestPerform requestPerform) throws NonExistentCustomerException  {

        //controle des données connexes
        //Customer
        Customer whoIsHe = requestPerform.getCustomer();
        logger.info("Le CLIENT : \t\n");
        logger.info(whoIsHe.toString());
        logger.info("\t\n");

        //verifier le client
        logger.info("Le CLIENT  verifié: \t\n");
        Customer customerChecked = retrieveCustomerById(requestPerform.getCustomer().getId());
        logger.info(customerChecked.toString());
        requestPerform.setCustomer(customerChecked);



        logger.info("Le CLIENT recuperé : \t\n");
        logger.info("l'id : "+requestPerform.getCustomer().getId());
        //Customer getIt =customerDao.findCustomerById(requestPerform.getCustomer().getId());

        //Customer cus ;
        Optional<Customer> getIt = customerDao.findById(1L);

        if (getIt.isPresent()) {
        //cus = getIt.get();
        logger.info("WWWWWWWWWWWWWw\t\n ! "+ getIt.get().toString());
        }

        //

//        logger.info(getIt.getName());
//        requestPerform.setCustomer(getIt);



        //Statut
        StatusRequestPerform status = requestPerform.getStatusRequestPerform();
        logger.info("LE STATUT : \t\n");
        logger.info(status.toString());
        logger.info("\t\n");

        //Event ->
        Event event = requestPerform.getEvent();
        logger.info("L'EVENEMENT : \t\n");
        logger.info(event.toString());
        logger.info("\t\n");


        // on part du principe ou tous les champs sont renseigné !!
        logger.info("Toutes les information de la demande : \t\n");
        logger.info(requestPerform.toString());

        //sauvegarde sans controle
        return requestPerformDao.save(requestPerform);
        //return null;
    }

    @Override
    /**
     * This method searches for the client by his id
     * @param id : is the identifier of the client in the database
     * @return Customer
     * @throws NonExistentCustomerException
     */
    public Customer retrieveCustomerById(Long id) throws NonExistentCustomerException{

        Customer customerFound = null;
        Optional<Customer> customerToCheck = customerDao.findById(id);

        if(!customerToCheck.isPresent()){

            logger.info("L'assuré ayant l'id :"+ id + " n'est pas présent");
            throw new NonExistentCustomerException("Client numéro : "+id+" inésistant");
        }
        customerFound =customerToCheck.get();

        return customerFound;

    }


    /// SETTERS ///

    @Autowired
    public void setRequestPerformDao(RequestPerformDao requestPerformDao) {
        this.requestPerformDao = requestPerformDao;
    }

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
