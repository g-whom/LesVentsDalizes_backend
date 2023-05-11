package fr.eql.ai113.LesVentsDalizes.entity.dto;

import fr.eql.ai113.LesVentsDalizes.entity.Address;

public class AddressWithUsernameDto {

    private String username;

    private AddressDto addressDto;


    /// CONSTRUCTORS ///


    public AddressWithUsernameDto() {
    }

    public AddressWithUsernameDto(String username, AddressDto addressDto) {
        this.username = username;
        this.addressDto = addressDto;
    }

    /// METHODES ///
    /// GETTERS ///

    public String getUsername() {
        return username;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    /// SETTERS ///

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    /// TOSTRING ///

    @Override
    public String toString() {
        return "AddressWithUsernameDto{" +
                "username='" + username + '\'' +
                ", addressDto=" + addressDto+
                '}';
    }
}
