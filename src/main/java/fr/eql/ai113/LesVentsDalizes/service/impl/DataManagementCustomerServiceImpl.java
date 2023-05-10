package fr.eql.ai113.LesVentsDalizes.service.impl;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.dto.AddressDto;
import fr.eql.ai113.LesVentsDalizes.entity.dto.AddressWithUsernameDto;
import fr.eql.ai113.LesVentsDalizes.entity.dto.PasswordDto;
import fr.eql.ai113.LesVentsDalizes.entity.dto.UsernameDto;
import fr.eql.ai113.LesVentsDalizes.exceptions.AddressExistException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentAddressException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentCustomerException;
import fr.eql.ai113.LesVentsDalizes.exceptions.ValidPasswordException;
import fr.eql.ai113.LesVentsDalizes.repository.AddressDao;
import fr.eql.ai113.LesVentsDalizes.repository.CustomerDao;
import fr.eql.ai113.LesVentsDalizes.service.DataManagementCustomerService;
import fr.eql.ai113.LesVentsDalizes.validators.PasswordValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.persistence.PersistenceException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DataManagementCustomerServiceImpl implements DataManagementCustomerService {

    Logger logger = LoggerFactory.getLogger(getClass());
   private CustomerDao customerDao;
   private AddressDao addressDao;



    /**
     * this methode permet de mettre à jour les informations d'un client
     * @param customer
     * @return
     * @throws NonExistentCustomerException
     */
    @Override
    public Customer updateCustomerData(Customer customer) throws NonExistentCustomerException, Exception {

        logger.info("  '>AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA ");

        Customer customerToCheck;
        try {
            if ( customerDao.findCustomerById(customer.getId()) == null){
                throw new NonExistentCustomerException("");
            }

            customerToCheck = customerDao.findCustomerById(customer.getId());
            logger.info("\t\n\t\n\r Voici les aanciennes data du customer "+customerToCheck);
            if (customerToCheck == null) {

                throw new NonExistentCustomerException("");
            }
            logger.info("\t\r\n\n\r YOoooooooooooooooooo    : "+customerToCheck.toString());
            customerToCheck.setName(customer.getName());
            customerToCheck.setSurname(customer.getSurname());
            customerToCheck.setBirthdate(customer.getBirthdate());
            customerToCheck.setPhoneNumber(customer.getPhoneNumber());
//            customerToCheck.setPassword(customer.getPassword());
//
//            customerToCheck.setSubscriptionDate(customer.getSubscriptionDate());
//            customerToCheck.setUsername(customer.getUsername());
//            customerToCheck.setAddress(customer.getAddress());
            return customerDao.save(customerToCheck);
        }catch (Exception e){
            logger.info("Une anomalie s'est produite lors de l'accès en base de donnée \r\n");
            throw new Exception("",e);
        }
    }

    /**
     * this method returns the client search by an identifier
     * @param idCustomer
     * @return
     * @throws NonExistentCustomerException
     */
    @Override
    public Customer fetchCustomerById(Long idCustomer) throws NonExistentCustomerException {
        //return null;
        logger.info("in: fetchCustomerById ...");

        if (  customerDao.findCustomerById(idCustomer) == null){
            throw new NonExistentCustomerException("");
        }

        Customer customerFind = customerDao.findCustomerById(idCustomer);
        logger.info("voici le client trouvé : "+customerFind.toString());

        return customerFind;
    }

    @Override
    public Customer fetchCustomerByUsername(String username) throws NonExistentCustomerException {
        if (  customerDao.findCustomerByUsername(username) == null){
            throw new NonExistentCustomerException("");
        }

        Customer customerFound = customerDao.findCustomerByUsername(username);
        logger.info("voici le client trouvé : "+username.toString());

        return customerFound;
    }

    /**
     * #version 01 : sans DTO
     * @param idCustomer
     * @return
     * @throws NonExistentCustomerException
     */
    @Override
    public Address getAddressCustomerFromIdCustomer(Long idCustomer)
            throws NonExistentCustomerException,
            NonExistentAddressException {
        if (  customerDao.findCustomerById(idCustomer) == null){
            throw new NonExistentCustomerException("");
        }
        Customer customerFound = customerDao.findCustomerById(idCustomer);

        Optional<Address> addressToCheck = addressDao.findById( customerFound.getAddress().getId() );
        Address addressFound;

        if ( addressToCheck.isPresent()){
            addressFound = addressToCheck.get();
            return addressFound;
        }
        throw new NonExistentAddressException();
    }

    @Override
    public Address getAddressById(Long idAddress) throws NonExistentAddressException {
        Optional<Address> addressToCheck = addressDao.findById(idAddress);
        if (!addressToCheck.isPresent()){
            throw new NonExistentAddressException();

        }
        return addressToCheck.get();

    }

    //WIP ANOMALIE : certains champs perdus
    @Override
    public Customer updateDataCustomer(Customer customer) throws NonExistentCustomerException, Exception{
        logger.info("  '>AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA ");

        Customer customerToCheck;
        try {
             customerToCheck = customerDao.findCustomerById(customer.getId());
             logger.info("\t\n\t\n\r Voici les aanciennes data du customer "+customerToCheck);
            if (customerToCheck == null) {

                throw new NonExistentCustomerException("");
            }
            logger.info("\t\r\n\n\r YOoooooooooooooooooo    : "+customerToCheck.toString());
            customerToCheck.setName(customer.getName());
            customerToCheck.setSurname(customer.getSurname());
            customerToCheck.setBirthdate(customer.getBirthdate());
            customerToCheck.setPhoneNumber(customer.getPhoneNumber());
//            customerToCheck.setPassword(customer.getPassword());
//
//            customerToCheck.setSubscriptionDate(customer.getSubscriptionDate());
//            customerToCheck.setUsername(customer.getUsername());
//            customerToCheck.setAddress(customer.getAddress());
           return customerDao.save(customerToCheck);
        }catch (Exception e){
            logger.info("Hpuston \r\n");
           throw new Exception("",e);
        }

    }

    @Override
    public List<Customer> fetchAllCustomer() {
        logger.info("on est dans FetchAllCustomer la heun ");

        List<Customer> customerList = customerDao.findAll();

        logger.info("des infos .. nombre de clients : "+customerList.size()+" details : "+customerList.toString());
        return customerList;
    }


    //WIP >>> Appliquer les validateuts ??

    /**
     * WIP (translate : update adresse ok si deja existante ne rien remplacer
     * @param address
     * @param idCustomer
     * @return
     * @throws NonExistentCustomerException
     * @throws AddressExistException
     * @throws Exception
     */
    @Override
    public Address updateAddressCustomer(Address address, Long idCustomer) throws
            NonExistentCustomerException,
            AddressExistException,
            Exception
    {

        try {
            Customer customerToCheck = customerDao.findCustomerById(idCustomer);
            if (customerToCheck == null) {
                throw new NonExistentCustomerException("");
            }

            Address addressToCheck = fetchAddress(address);
                    /* OLD
                    addressDao.findAddressByNumberRoadAndRoadAndCityAndCountryAndZipCode(
                    address.getNumberRoad(),
                    address.getRoad(),
                    address.getCity(),
                    address.getCountry(),
                    address.getZipCode() );*/

            Address addressUpdate = new Address();

            if (addressToCheck != null)  {
                addressUpdate = addressToCheck;
                //new AddressExistException();
            }else{
                addressUpdate = addressDao.save(address);
            }

            customerToCheck.setAddress(addressUpdate);
            customerDao.save(customerToCheck);
            return addressUpdate;
        }catch (Exception e){
           throw new Exception("");
        }
    }

    /**
     * WIP : met a jour le mot de passe du client
     * @param passwordDto
     * @return
     * @throws NonExistentCustomerException
     * @throws Exception
     */
    @Override
    public Customer updatePasswordCustomer(PasswordDto passwordDto) throws NonExistentCustomerException,  Exception{

        try{
            Customer customerFound = customerDao.findByUsernameAndPassword(passwordDto.getUsername(), passwordDto.getPassword());
            if (customerFound == null){
                 throw new NonExistentCustomerException("");
            }

            String encryptedPassword = BCrypt.hashpw(passwordDto.getPasswordNew(),BCrypt.gensalt());
            customerFound.setPassword(encryptedPassword);
            return  customerDao.save(customerFound);

        }catch (Exception e){
            throw new Exception(""+e);
        }
    }

    //
    @Override
    public Customer updateCustomerUsername(UsernameDto usernameDto) throws NonExistentCustomerException, Exception{
        try {
            Customer customerToUpdate = customerDao.findCustomerByUsername(usernameDto.getUsername().trim());
            if (customerToUpdate==null){
                throw new NonExistentCustomerException("");
            }
            customerToUpdate.setUsername(usernameDto.getUsernameNew().trim());
            return customerDao.save(customerToUpdate);

        }catch (Exception e){
            throw new Exception("");
        }

    }


    /**
     * <H2>this method updates the customer's address if it differs from the existing one</H2>
     *
     * <hr>
     * <ul> methods used :
     *     <li>{@link #fetchAddress(Address)}</li>
     * </ul>
     * <hr>
     *
     * @param addressWithUsernameDto - object which includes an address and a customer's username
     * @return Address - corresponds to the last address to be associated to the user
     * (whether it has been updated or not
     * @throws NonExistentCustomerException
     * @throws DataAccessException
     * @throws PersistenceException
     * @see
     * @Author: J.Vent
     */
    @Override
    public Address updateAddressCustomerFromUsername(AddressWithUsernameDto addressWithUsernameDto) throws
            NonExistentCustomerException,
            DataAccessException,
            PersistenceException{

        try{

            Customer customer = customerDao.findCustomerByUsername(addressWithUsernameDto.getUsername().trim());
            if(customer==null){
                logger.info("Oups : l'identifiant {} est inconnu dans le systeme - Customer inexistant", addressWithUsernameDto.getUsername());
                throw new NonExistentCustomerException("");
            }

            Address addressFound = fetchAddress(addressWithUsernameDto.getAddressDto().convertAddressDtoToAdress());

            if (addressFound != null){
                return addressFound;
            }

            Address addressUpdated = addressDao.save(addressWithUsernameDto.getAddressDto().convertAddressDtoToAdress());
            return addressUpdated;

        }catch (DataAccessException e){
            logger.info("La base de données semble inaxecible");
            throw new DataAccessException("") {};
        }catch (PersistenceException e){
            logger.info("Une erreur s'est produite lors de l'enregistrement de la nouvelle adresse du customer");
            throw new PersistenceException("");
        }
        //return null;
    }



    @Override
    public Address findAddressCustomerFromIdCustomer(Long idCustomer) throws
            NonExistentCustomerException,
            NonExistentAddressException,
            DataAccessException,
            PersistenceException{
        try {
            Customer customer = customerDao.findCustomerById(idCustomer);
            if(customer==null){
                logger.info("Oups !! l'id :  {} est inconnu dans le systeme - Customer inexistant", idCustomer);
                throw new NonExistentCustomerException("");
            }

            Optional<Address> addressFound = addressDao.findById(customer.getAddress().getId());
            if (addressFound.isPresent()){
                return addressFound.get();
            }
            throw new NonExistentAddressException();
        }catch (DataAccessException e){
            logger.info("La base de données semble inaxecible");
            throw new DataAccessException("") {};
        }catch (PersistenceException e){
            logger.info("Une erreur s'est produite lors de l'enregistrement de la nouvelle adresse du customer");
            throw new PersistenceException("");
        }

    }


    /**
     * This method returns the searched address or null otherwise
     *
     * <hr/>
     * <ul>
     *     <p>Here are the methods that use it</p>
     *     <li>{@link  #updateAddressCustomer(Address address, Long idCustomer)}</li>
     *     <li>{@link #updateAddressCustomerFromUsername(AddressWithUsernameDto addressWithUsernameDto) }</li>
     * </ul>
     * <hr/>
     *
     * @param address - corresponds to an address object, the id of the address is not used
     * @return Address - matches the target address in the database if found otherwise null
     * @Author : J.Vent
     */
    private Address fetchAddress(Address address){

        Address addressFound = addressDao.findAddressByNumberRoadAndRoadAndCityAndCountryAndZipCode(
                address.getNumberRoad().trim(),
                address.getRoad().trim(),
                address.getCity().trim(),
                address.getCountry().trim(),
                address.getZipCode().trim() );

        return addressFound;
    }

    /// SETTERS ///

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Autowired
    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }


}
