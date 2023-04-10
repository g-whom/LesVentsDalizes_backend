package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories_instruments")
public class CategoryInstrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * this attribute describes the instrument category label
     */
    private String label;

    /**
     * the state will be used to display or hide the item in the available list of CategoryInstrument
     */
    private boolean available;

    //--[WIP]------------CLASS >> --- Links
    @OneToMany(mappedBy ="categoryInstrument")
    private Set<Instrument> instrumentSet = new HashSet<>();

    /// CONSTRUCTOR ///
    /// METHODES ///
    /// GETTERS ///
    /// SETTERS ///
    /// TOSTRING ///

}
