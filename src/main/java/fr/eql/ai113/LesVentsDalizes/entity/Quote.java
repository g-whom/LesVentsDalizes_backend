package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * This class correspond to the estimqte carried out after a feasibiliy study of perfom
 */
@Entity
public class Quote {
    @Id
    Long id;
    String label;

    LocalDate creationDate;

    LocalDate startDateOfValidity;

    LocalDate endDateOfValidity;

    float amount;

    String details;



    //Customer customer;




}
