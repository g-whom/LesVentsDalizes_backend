package fr.eql.ai113.LesVentsDalizes.entity.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.eql.ai113.LesVentsDalizes.deserializer.LocalDateDeserializer;
import fr.eql.ai113.LesVentsDalizes.entity.Address;
import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.RequestPerform;
import fr.eql.ai113.LesVentsDalizes.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class represents a customer in the customer management system
 */

public class CustomerDto implements UserDetails, Serializable {

    private Long id;
    private String name;
    private String surname;
    /**
     * <h3>>field corresponding to the date of birth;</h3
     *<p>A custom deserialized class is applied to allow <br/>the control of the validity of the date format</p>
     */
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthdate;
    private LocalDate subscriptionDate;
    private String username;

    /**
     * this attribute corresponds to the second entry of the password (username)
     */
    private String confirmPassword;
    private String password;
    private String phoneNumber;
    private LocalDate accountClosingDate;

    public Address address ;

    private List<RequestPerform> requestPerformList = new ArrayList<>();

    private Collection<Role> roles = new ArrayList<>();


    //// CONSTRUCTOR ////


    public CustomerDto() {
    }

    public CustomerDto(Long id, String name, String surname, LocalDate birthdate, LocalDate subscriptionDate,
                       String username, String password, String phoneNumber, LocalDate accountClosingDate,
                       Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.subscriptionDate = subscriptionDate;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountClosingDate = accountClosingDate;
        this.address = address;

    }

    public CustomerDto(Long id, String name, String surname, LocalDate birthdate, LocalDate subscriptionDate,
                       String username, String confirmPassword, String password, String phoneNumber,
                       LocalDate accountClosingDate, Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.subscriptionDate = subscriptionDate;
        this.username = username;
        this.confirmPassword = confirmPassword;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountClosingDate = accountClosingDate;
        this.address = address;
    }
    //// METHODES  ////
//
//    /**
//     * this method converts object 'customerDto' into 'customer' , concerning the related data
//     * (Roles and Addresses, RequestPerforl) an eventual treatment will be applied according
//     * to the found identifiers.
//     *
//     * @return customer
//     */
//
//    public Customer convertCustomerDtoToCustomer(CustomerDto customerDto){
//
//        Customer customer = new Customer();
//        customer.setId(customerDto.getId());
//        customer.setName(customerDto.getName());
//        customer.setSurname(customerDto.getSurname());
//        customer.setUsername(customerDto.getUsername());
//        customer.setBirthdate(customerDto.getBirthdate());
//        customer.setSubscriptionDate(customerDto.getSubscriptionDate());
//        customer.setPhoneNumber(customerDto.getPhoneNumber());
//
//        if (customerDto.getAccountClosingDate() != null) {
//            customer.setAccountClosingDate(customerDto.getAccountClosingDate());
//        }
//
//        //For Address
//        if (customerDto.getAddressId() != -1){
//            Address addressToFeed = new Address();
//            addressToFeed.setId(customerDto.getId());
//            customer.setAddress(addressToFeed);
//        }
//
//        //For Roles
//        if (customerDto.getRolesIds().trim() != null){
//            String[] idsRoles = customerDto.getRolesIds().trim().split(",");
//
//            Collection<Role> roleCollection = new ArrayList<>();
//
//            for (String idRole : idsRoles){
//                Role role = new Role();
//                role.setId( Long.parseLong(  idRole) );
//                roleCollection.add(role);
//            }
//
//            customer.setRoles(roleCollection);
//        }
//
//
//        //For RequestPerform
// /*       if (customerDto.getRequestsPerformIds().trim() != null){
//            String[] idsRequestsPerform = customerDto.getRequestsPerformIds().trim().split(",");
//
//            List<RequestPerform> requestPerformList = new ArrayList<>();
//
//            for (String idRequestPerform : idsRequestsPerform){
//                RequestPerform requestPerform = new RequestPerform();
//                requestPerform.setId( Long.parseLong( idRequestPerform) );
//                requestPerformList.add( requestPerform);
//            }
//
//            customer.setRequestPerformList(requestPerformList);
//        }
//*/
//        return customer;
//
//    }


    /**
     * this method converts object 'customerDto' into 'customer' , concerning the related data
     * (Roles and Addresses, RequestPerform) an eventual treatment will be applied according
     * to the found identifiers.
     *
     * WIP for: RequestePerform
     *
     * @return customer
     */
    public Customer convertCustomerDtoToCustomer(){
        Customer customer= new Customer();
        if (this.getId() != null){
            customer.setId(this.getId());
        }
        customer.setName(this.name);
        customer.setSurname(this.surname);
        customer.setBirthdate(this.getBirthdate());
        customer.setUsername(this.getUsername());
        customer.setPassword(this.password);
        customer.setPhoneNumber(this.phoneNumber);
        if (this.accountClosingDate != null){
            customer.setAccountClosingDate(this.accountClosingDate);
        }
        //address
        customer.setAddress(address);

        //Role
        if (this.roles != null){
            customer.setRoles(this.getRoles());
       }
     /**
        if (this.getRolesIds().trim() != null){
            String[] idsRoles = this.getRolesIds().trim().split(",");

            Collection<Role> roleCollection = new ArrayList<>();

            for (String idRole : idsRoles){
                Role role = new Role();
                role.setId( Long.parseLong(  idRole) );
                roleCollection.add(role);
            }

            customer.setRoles(roleCollection);
        }
**/
        return customer;

    }



    //// METHODES  ////



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }


    //// GETTERS  ////


    public Collection<Role> getRoles() {
        return roles;
    }

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

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getAccountClosingDate() {
        return accountClosingDate;
    }

    public Address getAddress() {
        return address;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    //// SETTERS  ////


    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

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

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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
                ", address=" + address +
                ", roles=" + roles +
                '}';
    }
}
