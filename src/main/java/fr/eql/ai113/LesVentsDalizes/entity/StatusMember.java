package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * this class represents the status of the members (like a repository)
 */
@Entity
public class StatusMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String label;

    private boolean available;

    /// CONSTRUCTORS ///
    /// METHODES ///
    /// GETTERS ///
    /// SETTERS ///
    /// TOSTRING ///




}
