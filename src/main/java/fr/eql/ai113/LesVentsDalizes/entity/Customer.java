package fr.eql.ai113.LesVentsDalizes.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * This class represents a customer in the customer management system
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "customers")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "le nom doit etre renseigné")
    @NotEmpty(message = "le nom doit etre renseigné")
    @Column(name = "name")
    private String name;
    @NotNull(message = "le prénom doit etre renseigné")
    @NotEmpty(message = "le prénom doit etre renseigné")
    @Column(name = "surname")
    private String surname;
    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "subscription_date")
    private LocalDate subscriptionDate;

    /**
     *
     */
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "format de email est invalide")
    @Column(name = "email")
    private String email;


    @Column(name = "password")
    private String password;

    @NotNull(message = "le numéro de téléphone doit etre renseigné")
    @NotEmpty(message = "le numéro de téléphone doit etre renseigné")
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "request_perform_id", referencedColumnName = "id")
    private RequestPerform requestPerform;

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
     * @param email
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

    public Customer(Long id, String name, String surname, LocalDate birthdate, LocalDate subscriptionDate, String email, String password, String phoneNumber, LocalDate accountClosingDate, Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.subscriptionDate = subscriptionDate;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountClosingDate = accountClosingDate;
//        Addresse addresse1 = new Addresse(addresse.getId(),
//                addresse.getNumberRoad(), addresse.getRoad(),
//                addresse.getZipCode(), addresse.getCity(), addresse.getCountry());
        this.address = address;//addresse1;




    }

    /// FUNCTIONS ///

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

    public String getEmail() {
        return email;
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

    public Address getAddress() {
        return address;
    }

    /// SETTERS ///

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

    public void setEmail(String mail) {
        this.email = mail;
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

    public void setAddresse(Address address) {
        this.address = address;
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
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", accountClosingDate=" + accountClosingDate +
                ", addresse=" + address.toString() +
                '}';
    }
}
