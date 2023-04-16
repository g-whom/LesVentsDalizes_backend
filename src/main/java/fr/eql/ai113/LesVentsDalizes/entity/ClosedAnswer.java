package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.*;
import java.util.*;

/**
 * This class represents the closed answers to asociate to a potentially closed question
 */
@Entity
//@DiscriminatorValue("close")
//@PrimaryKeyJoinColumn(name="id")
//@Table(name = "close_answer")
public class ClosedAnswer extends Answer{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

   // private static final long serialVersionUID=1L;
    private long serialVersionUID=1L;
    /**
     * This attribute will feed qll the closed answers associated to a question, duplicqte
     * will not be possible
     */
    //@Column(name = "answer_list")
    //private Set<String> answerList = new LinkedHashSet<>();
    @ElementCollection
    @MapKeyColumn(name = "question_id")
    @Column(name = "valeur")
    private   Map<Long, String> cloqesAnswersList;




    /// CONSTRUCTOR ///


    ////// METHODES ////


    /// GETTERS ///

    /// SETTERS ///

    /// TO_STRING ////
}
