package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * class that represents the surveys for the members of the association
 */
@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surveyId;
    private String label;
    private String question;

    @OneToMany
    private List<Answer> SuggestedAnswersList=  new ArrayList<>();
    // OLD private List<Response> SuggestedAnswersList=  new ArrayList<>();

    LocalDate surveyCreationDate;

    @OneToOne
    Member surveyCreatorMember;
    @OneToMany
    List<Member> memberList;




}
