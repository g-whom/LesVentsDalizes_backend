package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    /**
     * This attribute is used to display or hide an answer associated with a question
     */
    boolean show;


    ///CONSTRUCTOR///

    /// FUNCTIONS ///

    /// GETTERS ////


    /// SETTERS ///

    /// TO STRING ///


}
