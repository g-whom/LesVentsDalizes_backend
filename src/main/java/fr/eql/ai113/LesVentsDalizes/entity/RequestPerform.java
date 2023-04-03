package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
    private LocalTime startTime;
    private LocalTime endTime;


    @Column(name = "description_request")
    private String descriptionRequest;

    //--[WIP]------------CLASS >> --- Links

//    @Column(name = "request_perform_id")
//    private Long requestPerformId;

    //WIP: Status_demande_prestation: StatusRequestPerfom
    // [ok] import.sql
    // [] link-up
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_request_perform_id", referencedColumnName = "id")
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

    public RequestPerform() {
    }

    public RequestPerform(Long id, LocalDate dateCreationRequest, LocalDate datePerformRequested, LocalTime startTime, LocalTime endTime, String descriptionRequest, StatusRequestPerform statusRequestPerform, Event event, Customer customer) {
        this.id = id;
        this.dateCreationRequest = dateCreationRequest;
        this.datePerformRequested = datePerformRequested;
        this.startTime = startTime;
        this.endTime = endTime;
        this.descriptionRequest = descriptionRequest;
        this.statusRequestPerform = statusRequestPerform;
        this.event = event;
        this.customer = customer;
    }

    /// METHODES ///
    /// GETTERS ///


    public Long getId() {
        return id;
    }

    public LocalDate getDateCreationRequest() {
        return dateCreationRequest;
    }

    public LocalDate getDatePerformRequested() {
        return datePerformRequested;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getDescriptionRequest() {
        return descriptionRequest;
    }

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


    public void setId(Long id) {
        this.id = id;
    }

    public void setDateCreationRequest(LocalDate dateCreationRequest) {
        this.dateCreationRequest = dateCreationRequest;
    }

    public void setDatePerformRequested(LocalDate datePerformRequested) {
        this.datePerformRequested = datePerformRequested;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setDescriptionRequest(String descriptionRequest) {
        this.descriptionRequest = descriptionRequest;
    }

    public void setStatusRequestPerform(StatusRequestPerform statusRequestPerform) {
        this.statusRequestPerform = statusRequestPerform;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /// TOSTRING ///

    @Override
    public String toString() {
        return "RequestPerform{" +
                "id=" + id +
                ", dateCreationRequest=" + dateCreationRequest +
                ", datePerformRequested=" + datePerformRequested +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", descriptionRequest='" + descriptionRequest + '\'' +
                ", statusRequestPerform=" + statusRequestPerform.toString() +
                ", event=" + event.toString() +
                ", customer=" + customer.toString() +
                '}';
    }
}
