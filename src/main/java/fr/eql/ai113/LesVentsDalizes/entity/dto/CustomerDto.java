package fr.eql.ai113.LesVentsDalizes.entity.dto;

import fr.eql.ai113.LesVentsDalizes.entity.Address;

import java.time.LocalDate;
/**
 * This class represents a customer in the customer management system
 */

public class CustomerDto {

    private Long id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private LocalDate subscriptionDate;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDate accountClosingDate;
    private Address address;
    public Long address_id;


    //// CONSTRUCTOR ////


    public CustomerDto() {
    }

    public CustomerDto(String name, String surname, LocalDate birthdate,
                       LocalDate subscriptionDate, String email, String password,
                       String phoneNumber, LocalDate accountClosingDate, Address address) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.subscriptionDate = subscriptionDate;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountClosingDate = accountClosingDate;
        this.address = address;
    }

    public CustomerDto(Long id, String name, String surname, LocalDate birthdate,
                       LocalDate subscriptionDate, String email, String password,
                       String phoneNumber, LocalDate accountClosingDate, Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.subscriptionDate = subscriptionDate;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountClosingDate = accountClosingDate;
        this.address = address;
    }

    public CustomerDto(String name, String surname, LocalDate birthdate,
                       LocalDate subscriptionDate, String email, String password,
                       String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.subscriptionDate = subscriptionDate;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public CustomerDto(String name, String surname, LocalDate birthdate,
                       LocalDate subscriptionDate, String email, String password,
                       String phoneNumber, Address address) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.subscriptionDate = subscriptionDate;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public CustomerDto(String name, String surname, LocalDate birthdate, LocalDate subscriptionDate,
                       String email, String password, String phoneNumber, LocalDate accountClosingDate,
                       Address address, Long address_id) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.subscriptionDate = subscriptionDate;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountClosingDate = accountClosingDate;
        this.address = address;
        this.address_id = address_id;
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

    public Long getAddress_id() {
        return address_id;
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

    public void setEmail(String email) {
        this.email = email;
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

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }
    //// TOSTRING ////

    public String toString() {
        return "AuthRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                ", subscriptionDate=" + subscriptionDate +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", accountClosingDate=" + accountClosingDate +
                ", address=" + address.toString() +
                ", address_id=" + address_id +
                '}';
    }



}
