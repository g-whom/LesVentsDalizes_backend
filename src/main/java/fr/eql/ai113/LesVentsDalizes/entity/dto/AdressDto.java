package fr.eql.ai113.LesVentsDalizes.entity.dto;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class AdressDto {


    private Long id;

    private String numberRoad;
    private String road;

    private String zipCode;

    private String city;

    private String country;

    private List<Customer> customerList = new ArrayList<>();
}
