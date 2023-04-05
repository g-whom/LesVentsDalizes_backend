package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represente the different states that a perform can have
 */

@Entity
public class StatusPerform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;


    /**
     * the state will be used to display or hide the item in the available list
     */
    boolean available;

    /// CONSTRUCTOR ///

    //// METHODE ////
    //// GETTERS ////

    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public boolean isAvailable() {
        return available;
    }

    //// SETTERS ////

    public void setId(Long id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    //// TOSTRING ////

    @Override
    public String toString() {
        return "StatusPerform{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", available=" + available +
                '}';
    }


//    PROGRAMMEE,
//    EN_COURS,
//    INTERROMPUE,
//    ANNULEE,
//    REPORTEE,
//    TERMINEE
}
