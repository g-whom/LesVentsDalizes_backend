package fr.eql.ai113.LesVentsDalizes.service.impl;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.Event;
import fr.eql.ai113.LesVentsDalizes.entity.RequestPerform;
import fr.eql.ai113.LesVentsDalizes.entity.StatusRequestPerform;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentCustomerException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentEventException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentStatusPerformException;
import fr.eql.ai113.LesVentsDalizes.repository.CustomerDao;
import fr.eql.ai113.LesVentsDalizes.repository.EventDao;
import fr.eql.ai113.LesVentsDalizes.repository.RequestPerformDao;
import fr.eql.ai113.LesVentsDalizes.repository.StatusRequestPerformDao;
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
    private EventDao eventDao;

    private StatusRequestPerformDao statusRequestPerformDao;



    //Retrouver un client





    //WIP en woute ...
    /*
    soit  on part du principe que seul l
     */
    @Override
    public RequestPerform applyingForPerformance(RequestPerform requestPerform)
            throws NonExistentCustomerException ,
            NonExistentEventException,
            NonExistentStatusPerformException {

        Customer customerChecked = retrieveCustomerById(requestPerform.getCustomer().getId());
        logger.info("Le CLIENT  verifié: \t\n"+customerChecked.toString());
        requestPerform.setCustomer(customerChecked);

        StatusRequestPerform statusRequestPerformChecked = retrieveStatusRequestPerformByID(requestPerform.getStatusRequestPerform().getId());
        logger.info("Le statut  vérifié de la demande : \t\n"+statusRequestPerformChecked.toString());
        requestPerform.setStatusRequestPerform(statusRequestPerformChecked);

        Event eventChecked = retrieveEventById(requestPerform.getEvent().getId());
        logger.info("L'EVENEMENT vérifié : \t\n"+eventChecked.toString());
        requestPerform.setEvent(eventChecked);


        // on part du principe ou tous les champs sont renseigné !!
        logger.info("Toutes les information de la demande : \t\n");

        //WIP : Vérififation de l'enregistrement en base de données
        logger.info(requestPerform.toString());

        //sauvegarde sans controle
        return requestPerformDao.save(requestPerform);
        //return null;
    }

    @Override
    /**
     * This method searches for the client by his id
     * @param id : is the identifier of the client in the database
     * @return Customer found
     * @throws NonExistentCustomerException
     */
    public Customer retrieveCustomerById(Long id) throws NonExistentCustomerException{

        Customer customerFound = null;
        Optional<Customer> customerToCheck = customerDao.findById(id);

        if(!customerToCheck.isPresent()){

            logger.info("L'assuré ayant l'id :"+ id + " n'est pas présent en bas de données");
            throw new NonExistentCustomerException("Client numéro : "+id+" est inésistant");
        }
        customerFound =customerToCheck.get();

        return customerFound;

    }

    /**
     *  This method searches the event by its id
     * @param id : is the identifier of the event in the database
     * @return Event found
     * @throws NonExistentEventException
     */
    @Override

    public Event retrieveEventById(Long id) throws NonExistentEventException{

        Event eventFound = null;
        Optional<Event> eventToCheck = eventDao.findById(id);

        if(!eventToCheck.isPresent()){
            logger.info("L'évènement ayant l'id : "+id+" n'est pas présent en base de données");
            throw new NonExistentEventException("Evènement numéro : "+id+" est inexistant");
        }
        eventFound = eventToCheck.get();
        return eventFound;
    }

    /**
     * tThis method searches the status of the request by its id
     * @param id :  is the identifier of the status of request in the database
     * @return status of resquest perfom
     * @throws NonExistentStatusPerformException
     */
    @Override
    public StatusRequestPerform retrieveStatusRequestPerformByID(Long id) throws NonExistentStatusPerformException {

        StatusRequestPerform statusRequestPerformFound = null;
        Optional<StatusRequestPerform> statusRequestPerformToCheck = statusRequestPerformDao.findById(id);

        if(!statusRequestPerformToCheck.isPresent()){
            logger.info("Le status de la demande ayant l'id : "+id+" n'est pas présent en base de données");
            throw new NonExistentStatusPerformException("Le statut numéro : "+id+" est inexistant");
        }
        statusRequestPerformFound = statusRequestPerformToCheck.get();
        return statusRequestPerformFound;
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

    @Autowired
    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Autowired
    public void setStatusRequestPerformDao(StatusRequestPerformDao statusRequestPerformDao) {
        this.statusRequestPerformDao = statusRequestPerformDao;
    }
}
