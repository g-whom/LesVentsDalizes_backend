package fr.eql.ai113.LesVentsDalizes.entity.dto;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
import fr.eql.ai113.LesVentsDalizes.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class AddressDto {


    private Long id;

    private String numberRoad;
    private String road;

    private String zipCode;

    private String city;

    private String country;

    private List<Customer> customerList = new ArrayList<>();


    /// CONSTRUCTORS ///

    public AddressDto() {
    }

    public AddressDto(Long id, String numberRoad, String road, String zipCode, String city, String country) {
        this.id = id;
        this.numberRoad = numberRoad;
        this.road = road;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    public AddressDto(Long id, String numberRoad, String road, String zipCode, String city, String country, List<Customer> customerList) {
        this.id = id;
        this.numberRoad = numberRoad;
        this.road = road;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.customerList = customerList;
    }

    /// METHODES ///

    /**
     * <h3>This method converts an object of 'AddressDto' into Addresst</h3>
     *
     * @return - Address
     */
    public Address convertAddressDtoToAdress( ){
        Address address = new Address();
        if (this.getId() != null){
            address.setId(this.getId());
        }
        address.setNumberRoad(this.getNumberRoad());
        address.setRoad(this.getRoad());
        address.setZipCode(this.getZipCode());
        address.setCity(this.getCity());
        address.setCountry(this.getCountry());

        return address;
    }
    /// GETTERS ///

    public Long getId() {
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

    public List<Customer> getCustomerList() {
        return customerList;
    }

    /// SETTERS ///

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumberRoad(String numberRoad) {
        this.numberRoad = numberRoad;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    /// TOSTRING ///

    @Override
    public String toString() {
        return "AddressDto{" +
                "id=" + id +
                ", numberRoad='" + numberRoad + '\'' +
                ", road='" + road + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
