package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.*;

@Entity
@Table(name = "instruments")
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "instrument_id")
    private Long id;

    private String label;

    private String description;

    private boolean available;

    //--[WIP]------------CLASS >> --- Links
    @ManyToOne
    @JoinColumn(name="category_instrument_id")
    private CategoryInstrument categoryInstrument;

    @ManyToOne
    @JoinColumn(name="status_instrument_id")
    private StatusInstrument statusInstrument;

    /// CONSTRUCTOR ///
    /// METHODES ///
    /// GETTERS ///
    /// SETTERS ///
    /// TOSTRING ///


}
