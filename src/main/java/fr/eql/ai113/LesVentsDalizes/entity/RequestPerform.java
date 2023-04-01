package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class RequestPerform {

    @Id
    @Column(name = "request_perform_id")
    private Long id;


    @Column(name = "date_creation_request")
    LocalDate dateCreationRequest;

    @Column(name="date_perform_requested")
    LocalDate datePerformRequested;

    @Column(name="start_time")
    LocalDate startTime;
    LocalDate duration;

    @Column(name = "description-request")
    String descriptionRequest;



}
