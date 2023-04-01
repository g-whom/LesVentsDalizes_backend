package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This class reprents the type of events for wich q performance request would be associated
 */
@Entity
public class Event {
    @Id
    @Column(name="event_id")
    private Long id;


    String label;

    /**
     * the state will be used to display or hide the item in the available list
     */
    boolean available;
}
