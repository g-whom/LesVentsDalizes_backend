package fr.eql.ai113.LesVentsDalizes.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class represents a customer in the customer management system
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "customers")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Customer implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotNull(message = "le nom doit etre renseigné")
    //@NotEmpty(message = "le nom doit etre renseigné")
    @Column(name = "name")
    private String name;
   // @NotNull(message = "le prénom doit etre renseigné")
    //@NotEmpty(message = "le prénom doit etre renseigné")
    @Column
            (name = "surname")
    private String surname;
    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "subscription_date")
    private LocalDate subscriptionDate;

    /**
     *
     */
    //@Column(name = "email", unique = true)
    @Column(name = "username",  unique = true)
   // @JsonIgnore
    private String username;


    @Column(name = "password")
    //@JsonIgnore
    private String password;

    //@NotNull(message = "le numéro de téléphone doit etre renseigné")
    //@NotEmpty(message = "le numéro de téléphone doit etre renseigné")
    @Column(name = "phone_number")

    private String phoneNumber;

    @Column(name = "account_closing_date")
    private LocalDate accountClosingDate;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "addresse_id")
//    @ElementCollection(targetClass = Addresse.class, fetch = FetchType.EAGER)

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Address address;




    //--[WIP]------------CLASS >> --- Links

    //[WIP] Demande : RequestPerfom
    // - [link - classes]
    // - [java]
    // - [bdd]
    // - [insertion data -> import.sql]
    // - [insertion data -> import.java]
    // - [insertion data -> import.Postman]
    //
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "request_perform_id", referencedColumnName = "id")
//    private RequestPerform requestPerform;
    //V2
    @OneToMany(mappedBy = "customer")
    private List<RequestPerform> requestPerformList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();


    /// CONSTRUCTOR ///



    /**
     * Default constructor for a customer
     */
    public Customer() {
    }

    /**
     * Constructor with parameters for a customer
     * @param name name of the customer
     * @param surname lastname of the customer
     * @param birthdate
     * @param username
     * @param password
     * @param phoneNumber
     * @param accountClosingDate
     */
//    public Customer(String name, String surname, LocalDate birthdate, String email, String password, String phoneNumber, LocalDate accountClosingDate) {
//        this.name = name;
//        this.surname = surname;
//        this.birthdate = birthdate;
//        this.email = email;
//        this.password = password;
//        this.phoneNumber = phoneNumber;
//        this.accountClosingDate = accountClosingDate;
//    }

    public Customer(Long id, String name, String surname, LocalDate birthdate, LocalDate subscriptionDate, String username, String password, String phoneNumber, LocalDate accountClosingDate, Address address) {
        this.id = id;
        setName(name); //this.name = name;
        setSurname(surname); //this.surname = surname;
        this.birthdate = birthdate;
        this.subscriptionDate = subscriptionDate;
        setUsername(username); //this.email = email;
        this.password = password;
        setPhoneNumber(phoneNumber); //this.phoneNumber = phoneNumber;
        this.accountClosingDate = accountClosingDate;
        this.address = address;//addresse1;

    }


    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /// FUNCTIONS ///

    /// OVERIDE ///


    /// GETTERS ///:

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

//    public String getUsername() {
//        return username;
//    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return null;
        return roles;
    }


    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        //return null;
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        //return false;
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //return false;
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //return false;
        return true;
    }

    @Override
    public boolean isEnabled() {
        //return false;
        return true;
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



    /// SETTERS ///

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public void setSurname(String surname) {
        this.surname = surname.trim();
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setSubscriptionDate(LocalDate subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public void setUsername(String mail) {
        this.username = mail.trim();
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber.trim();
    }

    public void setAccountClosingDate(LocalDate accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    /// HASHCODE ///

    /// EQUALS ///

    /// TOSTRING ///



    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                ", subscriptionDate=" + subscriptionDate +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", accountClosingDate=" + accountClosingDate +
                ", address=" + address.toString() +
                ", roles=" + roles.toString() +
                '}';
    }

}
