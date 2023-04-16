package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.*;

@Entity
//@DiscriminatorValue("open")
//@PrimaryKeyJoinColumn(name = "id")
//@Table(name = "open_answer")
public class OpenAnswer extends Answer{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

   // private static final long serialVersionUID=1L;
    private long serialVersionUID=1L;
    @Column(name = "member_input")
    private String memberInput;

    /// CONSTRUCTOR ///


    ////// METHODES ////


    /// GETTERS ///

    /// SETTERS ///

    /// TO_STRING ////
}
