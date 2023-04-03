package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StatusRequestPerform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    boolean available;



    /// CONSTRUCTOR ///
    /// METHODES ///
    /// GETTERS ///

    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public boolean isAvailable() {
        return available;
    }

    /// SETTERS ///

    public void setId(Long id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    /// TOSTRING ///

    @Override
    public String toString() {
        return "StatusRequestPerform{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", available=" + available +
                '}';
    }
}
