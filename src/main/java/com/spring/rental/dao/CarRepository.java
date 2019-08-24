package com.spring.rental.dao;

import com.spring.rental.domain.Car;
import com.spring.rental.enums.NumberOfSeats;
import com.spring.rental.enums.Transmission;
import com.spring.rental.enums.VehicleMake;
import com.spring.rental.enums.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT * FROM CAR c WHERE c.rented = false" +
            "      AND c.vehicle_type =:vehicleType",
            nativeQuery = true)
    Set<Car> searchCarsByType(@Param("vehicleType") String vehicleType);


    @Query(value = "SELECT * FROM CAR c WHERE c.rented = false" +
            "      AND c.transmission =:transmission",
            nativeQuery = true)
    Set<Car> searchCarsByTransmission(@Param("transmission") String transmission);

    @Query(value = "SELECT * FROM CAR c WHERE c.rented = false" +
            "      AND c.vehicle_make =:vehicleMake",
            nativeQuery = true)
    Set<Car> searchCarsByMake(@Param("vehicleMake") String vehicleMake);



    @Query(value = "SELECT * FROM CAR c WHERE c.rented = false" +
            "      AND c.seats =:seats",
            nativeQuery = true)
    Set<Car> searchCarsBySeats(@Param("seats") Integer seats);
}