package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This class represents a quetion to be associated with a survey
 */
@Entity
public class Question {
    @Id
    private Long id;

    private String label;
}
