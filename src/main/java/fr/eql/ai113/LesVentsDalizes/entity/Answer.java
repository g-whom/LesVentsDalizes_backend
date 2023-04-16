package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "answer")
//@DiscriminatorColumn(name = "entity_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Answer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * This attribute is used to display or hide an answer associated with a question
     */
    @Column(name = "display")
    private boolean display;



    ///CONSTRUCTOR///

    /// FUNCTIONS ///

    /// GETTERS ////


    /// SETTERS ///

    /// TO STRING ///


}
