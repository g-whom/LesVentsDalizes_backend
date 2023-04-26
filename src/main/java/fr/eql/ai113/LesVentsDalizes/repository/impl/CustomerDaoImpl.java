//package fr.eql.ai113.LesVentsDalizes.repository.impl;
//
//import fr.eql.ai113.LesVentsDalizes.entity.Customer;
//import fr.eql.ai113.LesVentsDalizes.repository.CustomerDao;
//import org.springframework.data.jpa.repository.Query;
//
//import javax.persistence.TypedQuery;
//import java.util.List;
//
//public class CustomerDaoImpl implements CustomerDao {
//    @Override
//    @Query('SELECT * from Customers c where c.dtype = :valeu')
//    public List<Customer> fetchAllCustomerTypeOnly() {
//
//        TypedQuery<Customer> query = entityManager.createQuery();
//        return null;
//
//        /*
//        TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c WHERE TYPE(c) = VipClient", Client.class);
//        return query.getResultList();
//         */
//    }
//}
