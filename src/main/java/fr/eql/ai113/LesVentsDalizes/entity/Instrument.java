package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instrument {
    @Id
    @Column(name = "instrument_id")
    private Long id;


    String label;

    String description;

}
