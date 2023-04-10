package fr.eql.ai113.LesVentsDalizes.entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * this class represents the status that a musical instrument can have
 */
@Entity
public class StatusInstrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * this attribute describes the status of instrument label
     */
    private String label;

    /**
     * the state will be used to display or hide the item in the available list of StatusInstrument
     */
    private boolean available;


    //--[WIP]------------CLASS >> --- Links
    @OneToMany(mappedBy ="statusInstrument")
    private Set<Instrument> instrumentSet = new HashSet<>();
    /*
       @OneToMany(mappedBy ="categoryInstrument")
    private Set<Instrument> instrumentList = new HashSet<>();
     */

    /// CONSTRUCTOR ///
    /// METHODES ///
    /// GETTERS ///
    /// SETTERS ///
    /// TOSTRING ///

    /*
    NEUF,
    COMME_NEUF,
    EXELLENT_ETAT,
    BON_ETAT,
    USE,
    ENDOMMAGE,
    EN_REPARATION,
    PERDU,
    VOLE,
*/
}
