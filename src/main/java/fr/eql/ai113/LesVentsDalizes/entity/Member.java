package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * this class represents the members of the association
 */
@Entity(name = "member")
public class Member extends Customer{


    /**
     * This attribut correponds to the dqte of registrqtion of the new member of the association
     */

    @Column(name = "date_of_membership")
    private LocalDate dateOfMembership;

    /**
     * This attribut corresponds to the registration fee that a memeber pf the association must
     * pay when registyering in order to cover part oh th internal costs.
     */
    @Column(name = "registration_fee")
    private float  registrationFee;

    /**
     * This attribut refers to whether or not a member is current on his:her annual dues payment
     */
    @Column(name = "up_to_date")
    private boolean upToDate;

    /**
     * This attribute allows to specify if it is an account update, a customer can become a member
     * of the association, this informations as a customer can be ketp!
     */
    @Column(name = "customer_becoming_member")
    private boolean customerBecomingMember;


    /**
     * This attribute corresponds to annual dues paid after the year of enrollment
     */
//    @ManyToOne
//    @JoinColumn(referencedColumnName = "id")
//    private Address address;

    /*
        @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Address address;
     */


    /// CONSTRUCTOR ///


    public Member() {
        super();
    }

//    public Member(Integer id, String name, String surname, LocalDate birthdate,
//                  LocalDate subscriptionDate, String email, String password, String phoneNumber,
//                  LocalDate accountClosingDate, Address address, LocalDate dateOfMembership) {
//        super(id, name, surname, birthdate, subscriptionDate, email, password, phoneNumber,
//                accountClosingDate, address);
//        this.dateOfMembership = dateOfMembership;
//    }

    public Member(Long id, String name, String surname, LocalDate birthdate,
                  LocalDate subscriptionDate, String email, String password, String phoneNumber,
                  LocalDate accountClosingDate, Address address, LocalDate dateOfMembership,
                  float registrationFee, boolean upToDate, boolean customerBecomingMember) {
        super(id, name, surname, birthdate, subscriptionDate, email, password, phoneNumber,
                accountClosingDate, address);
        this.dateOfMembership = dateOfMembership;
        this.registrationFee = registrationFee;
        this.upToDate = upToDate;
        this.customerBecomingMember = customerBecomingMember;
    }

    /**
     * this constructor that will only take the information of a member that a customer does not have
     * @param dateOfMembership
     * @param registrationFee
     * @param upToDate - will be processed at the creation (true by default ?)
     * @param customerBecomingMember : true if is a old customer
     */
    public Member(LocalDate dateOfMembership, float registrationFee, boolean upToDate,
                  boolean customerBecomingMember) {
        this.dateOfMembership = dateOfMembership;
        this.registrationFee = registrationFee;
        this.upToDate = upToDate;
        this.customerBecomingMember = customerBecomingMember;
    }

    /// METHODS ///


    /// GETTERS ///

    public float getRegistrationFee() {
        return registrationFee;
    }

    public boolean getUpToDate() {
        return upToDate;
    }

    /// SETTERS ///

    public void setDateOfMembership(LocalDate dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public void setRegistrationFee(float registrationFee) {
        this.registrationFee = registrationFee;
    }

    public void setUpToDate(boolean upToDate) {
        this.upToDate = upToDate;
    }

    public void setCustomerBecomingMember(boolean customerBecomingMember) {
        this.customerBecomingMember = customerBecomingMember;
    }
    /// TOSTRING ////

    @Override
    public String toString() {
        return "Member{" +
                "dateOfMembership=" + dateOfMembership +
                ", registrationFee=" + registrationFee +
                ", upToDate=" + upToDate +
                ", customerBecomingMember=" + customerBecomingMember +
               // ", address=" + address +
                '}';
    }
}
