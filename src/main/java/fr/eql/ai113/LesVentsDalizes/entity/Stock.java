package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stock {
    @Id
    @Column(name = "stock_id")
    private Long stockId;

    Integer quantity;



}
