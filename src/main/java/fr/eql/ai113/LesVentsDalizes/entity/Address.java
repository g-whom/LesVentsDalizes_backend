package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number_road")
    private String numberRoad;
    @Column(name = "road")
    private String road;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Customer> customerList = new ArrayList<>();


    //@OneToMany(mappedBy = "addresse", cascade = CascadeType.ALL)
   // private Set<Customer> customer;


    /// CONSTRUCTOR ///


    public Address() {
    }

    /**
     * Constructoe of Addresses that normalizes attributes using Setters 2.0
     * @param id
     * @param numberRoad
     * @param road
     * @param zipCode
     * @param city
     * @param country
     */
    public Address(Integer id, String numberRoad, String road, String zipCode, String city, String country) {
        //this.id = id;
        setId(id);
        //this.numberRoad =
        setNumberRoad(numberRoad);
        //this.road =
        normaliseString(road);
        //this.zipCode =
        normaliseString(zipCode);
        //this.city =
        normaliseString(city);
        //this.country =
        normaliseString(country);
    }


    ///////////////// METHODES

    String normaliseString(String inputText){
        return inputText
                .trim().toLowerCase();
    }


    /// GETTERS ///

    public Integer getId() {
        return id;
    }

    public String getNumberRoad() {
        return numberRoad;
    }

    public String getRoad() {
        return road;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

//    public Set<Customer> getCustomer() {
//        return customer;
//    }

    ///  SETTERS ////

    public void setCity(String city) {
        this.city = normaliseString(city);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumberRoad(String numberRoad) {
        this.numberRoad = normaliseString(numberRoad);
    }

    public void setRoad(String road) {
        this.road = normaliseString(road);
    }

    public void setZipCode(String zipCode) {
        this.zipCode = normaliseString(zipCode);
    }

    public void setCountry(String country) {
        this.country = normaliseString(country);
    }

//    public void setCustomer(Set<Customer> customer) {
//        this.customer = customer;
//    }

    //// HASHCODE ///
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals( numberRoad , address.numberRoad) &&
                Objects.equals(zipCode, address.zipCode) &&
                Objects.equals(city, address.city) &&
                Objects.equals(country, address.country) &&
                Objects.equals(zipCode, address.zipCode) ;
    }

    /// EQUALS ////
    @Override
    public int hashCode() {
        return Objects.hash(numberRoad, zipCode, city, country, zipCode);
    }



    /// TOSTRING /////

    @Override
    public String toString() {
        return "Addresse{" +
                "id=" + id +
                ", numberRoad='" + numberRoad + '\'' +
                ", road='" + road + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    // getters et setters

}
