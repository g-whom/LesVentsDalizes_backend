package fr.eql.ai113.LesVentsDalizes.entity;

import java.time.LocalDate;

/**
 * This class correspond to the annual fee that members must pay to take advantage of all that the association offers
 */
public class Season {

    private Integer id;

    /**
     * This attribute correspond to the start date of the new season of the association
     */
    private LocalDate startDate;
    /**
     * This attribute correspond to the end datre of the new season of the association
     */
    private LocalDate endDate;

    /**
     * this attribute correspond to the amound of the annual fee that members must pay
     */
    private float amount;


    /// CONSTRUCTOR ///

    public Season() {
    }

    public Season(Integer id, LocalDate startDate, LocalDate endDate, float amount) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
    }

    /// METHODS ///
    /// GETTER ///
    /// SETTER ///
    /// TOSTRING ///


    @Override
    public String toString() {
        return "Season{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", amount=" + amount +
                '}';
    }
}
