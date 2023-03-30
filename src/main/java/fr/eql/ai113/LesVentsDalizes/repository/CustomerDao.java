package fr.eql.ai113.LesVentsDalizes.repository;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {


    Customer findCustomerByEmail(String email); //existsByEmail(String email);


    Customer save(Customer customer);




    Customer findCustomerById(Integer id);
}
