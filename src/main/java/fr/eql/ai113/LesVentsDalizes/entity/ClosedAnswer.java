package fr.eql.ai113.LesVentsDalizes.entity;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * This class represents the closed answers to asociate to a potentially closed question
 */
public class ClosedAnswer extends Answer{
    /**
     * This attribute will feed qll the closed answers associated to a question, duplicqte
     * will not be possible
     */
    private Set<String> answerList = new LinkedHashSet<>();




    /// CONSTRUCTOR ///


    ////// METHODES ////


    /// GETTERS ///

    /// SETTERS ///

    /// TO_STRING ////
}
