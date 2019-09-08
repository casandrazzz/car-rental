package com.spring.rental.dao;

import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarReservationDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    /**
     * queries for finding a car by id and finding all cars
     * @param pkC
     * @return list of cars
     */
    Car findById(@Param("pkCar") long pkC);



     @Query("SELECT new com.spring.rental.dto.CarReservationDto(c.vehicleType, c.vehicleMake, c.vehicleModel, c.transmission, c.seats) FROM Car c")
    List<CarReservationDto> findAll(Specification<CarReservationDto> spec);
}