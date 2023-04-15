package fr.eql.ai113.LesVentsDalizes.service.impl;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.Member;
import fr.eql.ai113.LesVentsDalizes.repository.AddressDao;
import fr.eql.ai113.LesVentsDalizes.repository.CustomerDao;
import fr.eql.ai113.LesVentsDalizes.repository.MemberDao;
import fr.eql.ai113.LesVentsDalizes.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    //injecté par le setter
    private CustomerDao customerDao;

    //injecté par le setter
    private AddressDao addressDao;

    //injeté par le setter
    private MemberDao memberDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

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
    public Member registerNewMember(Member member) {

        //WIP cas spécifique

        // un client > devient membre (donc le mail est conservé) ou creer un alerte pour etre sur !!

        // un membre ne doit pas etre connu du systeme,  alerte le mail est-il bon ?

        //cas sans problemes
        Address address = member.getAddress();
        address =addressDao.save(address);

        System.out.println("avons nous le montant ? : "+member.getRegistrationFee());
        System.out.println("vrais ou faux (upToDate) ? "+ member.getUpToDate());

        member.setAddress(address);

        System.out.println("l'addresse du 1er membre\t\n\t\n : "+ member.toString());



        /*
         Address addressWIP = customer.getAddress();

        if (registrationService.checkIfAddressAlreadyUsed(addressWIP)!=null){
            addressWIP = registrationService.checkIfAddressAlreadyUsed(addressWIP);

        }
        Address addressCustomerValidate = registrationService.createAddresseCustomer(addressWIP);

        logger.info("VERIFION =>>>>>>>>>>>>>>>>> : "+addressCustomerValidate.toString());
        customer.setAddresse(addressCustomerValidate);
        customer.setSubscriptionDate(LocalDate.now());

        logger.info("SHOW THE CUSTOMER INFO :: \r\n"+ customer.toString());
        return ResponseEntity.ok(registrationService.createCustomerAccount(customer));
         */


        return memberDao.save(member);
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
    public Customer findCustomerById(Long id) {
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


    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
}
