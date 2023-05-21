package fr.eql.ai113.LesVentsDalizes.repository;

import fr.eql.ai113.LesVentsDalizes.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address, Long> {

    Address save(Address address);

    //find an address through all its elements
//    @Query("SELECT a FROM Address a " +
//            "WHERE a.numberRoad = :numberRoad " +
//            "AND a.road = :road " +
//            "AND a.city = :city " +
//            "AND a.zipCode = :zipCode " +
//            "AND a.country = :country ")
//    Address findPostalAddress(@Param("addresses")Address address);


//    @Query("SELECT a FROM Address a  WHERE a.numberRoad =:#{address.numberRoad}  AND a.road =:#{address.road}  AND a.city =:#{address.city}  AND a.zipCode =:#{address.zipCode} AND a.country =:#{address.country}")
//    Address findPostalAddress(@Param("addresses") Address address);

    //@Query("SELECT a FROM Address a  WHERE a.numberRoad =:#{address.numberRoad}  AND a.road =:#{address.road}  AND a.city =:#{address.city}  AND a.zipCode =:#{address.zipCode} AND a.country =:#{address.country}")
    Address findAddressByNumberRoadAndRoadAndCityAndCountryAndZipCode(
            String numberRoad, String road, String City, String Country, String zipCod
    );







   // Addresse findAddresseByNumberRoadAndRoadAndCityAndZipCodeAndCountry(String numberRoad, String road, String city, String zipCode, String country);



}
