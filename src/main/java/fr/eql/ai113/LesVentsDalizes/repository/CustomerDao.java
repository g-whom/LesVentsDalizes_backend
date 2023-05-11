package fr.eql.ai113.LesVentsDalizes.repository;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.dto.CustomerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {


    //Customer findCustomerByEmail(String email); //existsByEmail(String email);
    Customer findCustomerByUsername(String username);



    CustomerDto save(CustomerDto customerDto);

    /*
     @Query("from Assure a where a.numeroAssure = :na")
    List<Assure> rechercherAssureParLeNumero(@Param("na") String numeroAssure);
     */


    List<Customer> findAll();

    Customer findCustomerById(Long id);

    Customer findByIdAndPassword(Long id, String password);
    Customer findByUsernameAndPassword(String username, String password);


    /**
     * this method will update the client's address, by associating the right address id known by the system
     * @param customerId
     * @param addressId
     */
    @Modifying
    @Query("UPDATE Customer c SET c.address = :address WHERE c.id = :customerId" )
    void updateCustomerIdAddress(Long customerId, Address address);
    /*
    @Modifying
    @Query("UPDATE User u SET u.name = :newName WHERE u.id = :userId")
    void updateUserName(Long userId, String newName);
     */



}
