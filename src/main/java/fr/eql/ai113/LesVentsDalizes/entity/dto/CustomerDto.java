package fr.eql.ai113.LesVentsDalizes.entity.dto;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.RequestPerform;
import fr.eql.ai113.LesVentsDalizes.entity.Role;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class represents a customer in the customer management system
 */

public class CustomerDto {



    private Long id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private LocalDate subscriptionDate;
    private String username;
    private String password;
    private String phoneNumber;
    private LocalDate accountClosingDate;

    public Long addressId;

    public String rolesIds;

    public String requestsPerformIds;


    //// CONSTRUCTOR ////


    public CustomerDto() {
    }

    public CustomerDto(String name, String surname, LocalDate birthdate,
                       LocalDate subscriptionDate, String username, String password,
                       String phoneNumber, LocalDate accountClosingDate) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.subscriptionDate = subscriptionDate;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountClosingDate = accountClosingDate;

    }

    public CustomerDto(Long id, String name, String surname, LocalDate birthdate,
                       LocalDate subscriptionDate, String username, String password,
                       String phoneNumber, LocalDate accountClosingDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.subscriptionDate = subscriptionDate;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountClosingDate = accountClosingDate;

    }

    public CustomerDto(String name, String surname, LocalDate birthdate,
                       LocalDate subscriptionDate, String username, String password,
                       String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.subscriptionDate = subscriptionDate;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }


    public CustomerDto(String name, String surname, LocalDate birthdate, LocalDate subscriptionDate,
                       String username, String password, String phoneNumber, LocalDate accountClosingDate,
                       Long addressId) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.subscriptionDate = subscriptionDate;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountClosingDate = accountClosingDate;
        this.addressId = addressId;
    }

    //// METHODES  ////

    /**
     * this method converts object 'customerDto' into 'customer' , concerning the related data
     * (Roles and Addresses, RequestPerforl) an eventual treatment will be applied according
     * to the found identifiers.
     *
     * @return customer
     */
    public Customer convertCustomerDtoToCustomer(CustomerDto customerDto){

        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setSurname(customerDto.getSurname());
        customer.setUsername(customerDto.getUsername());
        customer.setBirthdate(customerDto.getBirthdate());
        customer.setSubscriptionDate(customerDto.getSubscriptionDate());
        customer.setPhoneNumber(customerDto.getPhoneNumber());

        if (customerDto.getAccountClosingDate() != null) {
            customer.setAccountClosingDate(customerDto.getAccountClosingDate());
        }

        //For Address
        if (customerDto.getAddressId() != -1){
            Address addressToFeed = new Address();
            addressToFeed.setId(customerDto.getId());
            customer.setAddress(addressToFeed);
        }

        //For Roles
        if (customerDto.getRolesIds().trim() != null){
            String[] idsRoles = customerDto.getRolesIds().trim().split(",");

            Collection<Role> roleCollection = new ArrayList<>();

            for (String idRole : idsRoles){
                Role role = new Role();
                role.setId( Long.parseLong(  idRole) );
                roleCollection.add(role);
            }

            customer.setRoles(roleCollection);
        }


        //For RequestPerform
 /*       if (customerDto.getRequestsPerformIds().trim() != null){
            String[] idsRequestsPerform = customerDto.getRequestsPerformIds().trim().split(",");

            List<RequestPerform> requestPerformList = new ArrayList<>();

            for (String idRequestPerform : idsRequestsPerform){
                RequestPerform requestPerform = new RequestPerform();
                requestPerform.setId( Long.parseLong( idRequestPerform) );
                requestPerformList.add( requestPerform);
            }

            customer.setRequestPerformList(requestPerformList);
        }
*/
        return customer;

    }
    //// GETTERS  ////

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getAccountClosingDate() {
        return accountClosingDate;
    }



    public Long getAddressId() {
        return addressId;
    }

    public String getRolesIds() {
        return rolesIds;
    }

    public String getRequestsPerformIds() {
        return requestsPerformIds;
    }

    //// SETTERS  ////

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setSubscriptionDate(LocalDate subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAccountClosingDate(LocalDate accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }



    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public void setRolesIds(String rolesIds) {
        this.rolesIds = rolesIds;
    }

    public void setRequestsPerformIds(String requestsPerformIds) {
        this.requestsPerformIds = requestsPerformIds;
    }

    //// TOSTRING ////


    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                ", subscriptionDate=" + subscriptionDate +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", accountClosingDate=" + accountClosingDate +
                ", address_id=" + addressId +
                ", roles_id='" + rolesIds + '\'' +
                ", requests_perform_id='" + requestsPerformIds + '\'' +
                '}';
    }
}
