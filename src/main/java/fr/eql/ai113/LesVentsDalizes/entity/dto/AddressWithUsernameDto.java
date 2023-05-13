package fr.eql.ai113.LesVentsDalizes.entity.dto;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AddressWithUsernameDto extends AddressDto{

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
/*
    public AddressDto extractAddressDto(){
        AddressDto addressDto1=new AddressDto();

        if (this.getAddressDto().getId() != null){
            addressDto1.setId(this.getAddressDto().getId());
        }
        addressDto1.setNumberRoad(this.getAddressDto().getNumberRoad());
        addressDto1.setRoad(this.getAddressDto().getRoad());
        addressDto1.setZipCode(this.getAddressDto().getZipCode());
        addressDto1.setCity(this.getAddressDto().getCity());
        addressDto1.setCountry(this.getAddressDto().getCountry());

        return addressDto1;
    }
*/

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
