package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "request_perform")
public class RequestPerform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "request_perform_id")
    private Long id;


    @Column(name = "date_creation_request")
    private LocalDate dateCreationRequest;

    @Column(name="date_perform_requested")
    private LocalDate datePerformRequested;

    @Column(name="start_time")
    private LocalDate startTime;
    private LocalDate duration;


    @Column(name = "description_request")
    private String descriptionRequest;

    //--[WIP]------------CLASS >> --- Links

    @Column(name = "request_perform_id")
    private Long requestPerformId;

    //WIP: Status_demande_prestation: StatusRequestPerfom
    // [ok] import.sql
    // [] link-up
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "Status_request_perform")
    @Column(name ="status")
    private StatusRequestPerform statusRequestPerform;


    //WIP: Evenement : Event
    // [ok] import.sql
    // [] link-up
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;


    //WIP: Client : Customer
//    @ManyToOne(mappedBy = "requestPerform")0
//    private Customer customer;

    //V2
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    // [ok] class
    // [] link-up

    //WIP: Status Event (enumeration)
//d

   // @ElementCollection(targetClass = StatusRequestPerform.class, fetch = =FechType.LAZY)


    /*
      @JsonIgnore
    @ElementCollection(targetClass = PetCategory.class, fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "owner_favorite_pet_category")
    @Column(name = "favorite_pet_category")
    private List<PetCategory> favoritePetCategories = new ArrayList<>();
     */

    /// COSNTRUCTOR ///
    /// METHODES ///
    /// GETTERS ///

    public StatusRequestPerform getStatusRequestPerform() {
        return statusRequestPerform;
    }

    public Event getEvent() {
        return event;
    }

    public Customer getCustomer() {
        return customer;
    }

    /// SETTERS ///
    public void setStatusRequestPerform(StatusRequestPerform statusRequestPerform) {
        this.statusRequestPerform = statusRequestPerform;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
