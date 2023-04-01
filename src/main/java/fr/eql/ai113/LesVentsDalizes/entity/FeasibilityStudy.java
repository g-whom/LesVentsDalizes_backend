package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class FeasibilityStudy {
    @Id
    @Column(name = "feasibility_study_id")
    Integer id;
    @Column(name = "study_start_date")
    LocalDate studyStartDate;
    @Column(name = "study_end_date")
    LocalDate studyEndDate;

    @Column(name="description_study" )
    String descriptionStudy;
    @Column(name="response_study")
    Boolean responeStudy;

    @Column(name = "status")
    StatusFeasibilityStudy status;


}
