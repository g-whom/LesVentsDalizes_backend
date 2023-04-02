package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "request_perform")
public class RequestPerform {

    @Id
    //@Column(name = "request_perform_id")
    private Long id;


    @Column(name = "date_creation_request")
    LocalDate dateCreationRequest;

    @Column(name="date_perform_requested")
    LocalDate datePerformRequested;

    @Column(name="start_time")
    LocalDate startTime;
    LocalDate duration;


    @Column(name = "description_request")
    String descriptionRequest;

    //--[WIP]------------CLASS >> --- Links

    //WIP: Status_demande_prestation: StatusRequestPerfom
    // [ok] import.sql
    // [] link-up
    @Enumerated(EnumType.STRING)
    private StatusRequestPerform statusRequestPerform;

    //WIP: Evenement : Event
    // [ok] import.sql
    // [] link-up


    //WIP: Client : Customer
    @OneToOne(mappedBy = "requestPerform")
    private Customer customer;
    // [ok] class
    // [] link-up



}
