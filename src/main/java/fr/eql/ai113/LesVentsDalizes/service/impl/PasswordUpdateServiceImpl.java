package fr.eql.ai113.LesVentsDalizes.service.impl;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.repository.CustomerDao;
import fr.eql.ai113.LesVentsDalizes.service.PasswordUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PasswordUpdateServiceImpl implements PasswordUpdateService {

    CustomerDao customerDao;

    /**
     * This method will browse the row range of a column in order to change
     * the values with the Bcrypt function
     * @param tableName : name of the table concerned by the modifications
     * @param columnName : name of the targeted column (password)
     * @param startRow : start rank of the range of rows to process
     * @param endRow : end row of the range of rows to be processed
     */
    @Override
    @Transactional
    public void updateColumnPasswordWithBcrypt(String tableName, String columnName, int startRow, int endRow) {

        List<Customer> customerList = customerDao.findAll();

        for (int i = startRow-1; i<endRow ; i++){

            Customer customer = customerList.get(i);

            String encryptedPassword = BCrypt.hashpw(customer.getPassword(),BCrypt.gensalt());
            switch (columnName){
                case "password":
                    customer.setPassword(encryptedPassword);
                    break;
                default:
                    throw new IllegalArgumentException("Nom de colone invalide : " + columnName);
            }

        }

    }

    /// SETTER ///

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
