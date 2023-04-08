package fr.eql.ai113.LesVentsDalizes.service.impl;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.Event;
import fr.eql.ai113.LesVentsDalizes.entity.RequestPerform;
import fr.eql.ai113.LesVentsDalizes.entity.StatusRequestPerform;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentCustomerException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentEventException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentStatusPerformException;
import fr.eql.ai113.LesVentsDalizes.exceptions.RequestPerformRegistrationFailedException;
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


    /**
     * This method represents the association's demand for performance, so this demand is associated with a customer.
     * @param requestPerform : the request of perform
     * @return :The registered request for service
     * @throws NonExistentCustomerException
     * @throws NonExistentEventException
     * @throws NonExistentStatusPerformException
     * @throws RequestPerformRegistrationFailedException
     */
    @Override
    public RequestPerform applyingForPerformance(RequestPerform requestPerform)
            throws NonExistentCustomerException ,
            NonExistentEventException,
            NonExistentStatusPerformException,
            RequestPerformRegistrationFailedException{

        Customer customerChecked = retrieveCustomerById(requestPerform.getCustomer().getId());
        logger.info("Le CLIENT  verifié: \t\n"+customerChecked.toString());
        requestPerform.setCustomer(customerChecked);

        StatusRequestPerform statusRequestPerformChecked = retrieveStatusRequestPerformByID(requestPerform.getStatusRequestPerform().getId());
        logger.info("Le statut  vérifié de la demande : \t\n"+statusRequestPerformChecked.toString());
        requestPerform.setStatusRequestPerform(statusRequestPerformChecked);

        Event eventChecked = retrieveEventById(requestPerform.getEvent().getId());
        logger.info("L'EVENEMENT vérifié : \t\n"+eventChecked.toString());
        requestPerform.setEvent(eventChecked);


        // WIP : Dernier controle avant la sauvegarde

        //sauvegarde sans controle
        RequestPerform requestPerformRegistration = requestPerformDao.save(requestPerform);
        if (requestPerformRegistration == null){
            logger.info("L'enregistrement de la demande de prestation à échoué");
            throw new RequestPerformRegistrationFailedException("L'enregistrement de la demande de prestation à échoué");
        }
        return requestPerformRegistration ;

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

    @Override
    public Event feedEvents(Event event) {
        Event eventFound = null;

        //String eventNormalize = event.getLabel().trim().

        String value = event.getLabel().trim().toString();

        //
        Optional<Event> eventToCehck = Optional.ofNullable(eventDao.findByLabel(value));
        if (eventToCehck.isPresent()){
            eventFound = eventToCehck.get();
            return eventDao.save(eventFound);
        }

        //controle si c'est nul
        //controle si deja present ?
        //ajoute si possible
        //retourne si deja present
        return eventDao.save(event) ;
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
