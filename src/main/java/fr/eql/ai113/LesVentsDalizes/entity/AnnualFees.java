package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "annual_fees")
public class AnnualFees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    float amountFees;

    Integer year;

    LocalDate DatePayment;


    @OneToOne(mappedBy="")
    Customer customer;

    ///GETTERS///
    public Long getId() {
        return id;
    }


    ///SETTERS////
    public void setId(Long id) {
        this.id = id;
    }

}
