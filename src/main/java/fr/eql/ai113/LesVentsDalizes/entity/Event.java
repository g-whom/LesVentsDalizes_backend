package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class reprents the type of events for wich q performance request would be associated
 */
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String label;

    /**
     * the state will be used to display or hide the item in the available list
     */
    boolean available;

    //--[WIP]------------CLASS >> --- Links

    //-> RequestPerform
    //@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
//    @ManyToOne(optional = false )
//    @JoinColumn(name = "request_perform_id", referencedColumnName = "id")
//    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Event> eventList = new ArrayList<>();
   // private RequestPerform requestPerform    ;

    /// CONSTRUCTOR ///
    /// METHODES ///
    /// GETTERS ///
    /// SETTERS ///
    /// TO_STRING ///

}
