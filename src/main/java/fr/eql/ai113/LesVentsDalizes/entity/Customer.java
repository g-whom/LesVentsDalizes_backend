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
@Table(name = "customers")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
    public Customer(String name, String surname, LocalDate birthdate, String email, String password, String phoneNumber, LocalDate accountClosingDate) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountClosingDate = accountClosingDate;
    }

    /// FUNCTIONS ///

    /// GETTERS ///:

    public Integer getId() {
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


    /// SETTERS ///

    public void setId(Integer id) {
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


    /// HASHCODE ///

    /// EQUALS ///

    /// TOSTRING ///


}
