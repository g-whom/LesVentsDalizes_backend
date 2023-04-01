package fr.eql.ai113.LesVentsDalizes.entity;

import fr.eql.ai113.LesVentsDalizes.entity.Member;
import fr.eql.ai113.LesVentsDalizes.entity.StatusMember;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * class that represents the association of members with status
 */
@Entity
public class MemberStatusMember {

    @Id
    @GeneratedValue()
    Integer id;

    LocalDate dateJoining;
    @OneToOne
    @GeneratedValue(strategy = GenerationType.AUTO)
    Member member;
    @OneToOne
    @GeneratedValue(strategy = GenerationType.AUTO)
    StatusMember statusMember;


}
