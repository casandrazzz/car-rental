package com.spring.rental.dao;

import com.spring.rental.domain.Car;
import com.spring.rental.domain.Reservation;

import com.spring.rental.dto.CarFilterDto;
import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.dto.ReservationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    /**
     * queries to get available cars, for filtering cars, for getting all reservations of a customer
     * @param pickUpDate        pick-up date for the car, enlisted in reservation table
     * @param returnDate        return date for the car, enlisted in reservation table
     * @return specific lists
     */

    @Query(value = "SELECT * FROM CAR c WHERE NOT EXISTS (SELECT * FROM RESERVATION r where c.pk_car = r.pk_car AND pick_up_date < :pickUpDate AND return_date > :returnDate )" +
            "AND c.rented = false;",
    nativeQuery = true)
    Set<Car> getAvailableCars(@Param("pickUpDate") LocalDate pickUpDate, @Param("returnDate") LocalDate returnDate);


    @Query("SELECT new com.spring.rental.dto.CarReservationDto(c.vehicleType, c.vehicleMake, c.vehicleModel, c.transmission, c.seats) FROM Car c WHERE NOT EXISTS (SELECT r FROM Reservation r, Car c where c.pkCar = r.car AND pick_up_date < :pickUpDate AND return_date > :returnDate )"+
            "AND c.rented = false")
    Set<CarReservationDto> getAvailableCarReservationDto(@Param("pickUpDate") LocalDate pickUpDate, @Param("returnDate") LocalDate returnDate);


    @Query("SELECT new com.spring.rental.dto.CarFilterDto(c.pkCar, c.vehicleType, c.vehicleMake, c.transmission, c.seats) FROM Car c WHERE NOT EXISTS (SELECT r FROM Reservation r, Car c where c.pkCar = r.car AND pick_up_date < :pickUpDate AND return_date > :returnDate )"+
            "AND c.transmission =:transmission AND c.vehicleType =:vehicleType")
    List<CarFilterDto> filterAvailableCars (@Param("pickUpDate") LocalDate pickUpDate, @Param("returnDate") LocalDate returnDate, @Param("transmission") String transmission,
                                            @Param("vehicleType") String vehicleType
    );

    @Query("SELECT new com.spring.rental.dto.ReservationDto(r.location, r.pickUpDate, r.returnDate, r.customer, r.pk) FROM Reservation r WHERE EXISTS (SELECT c FROM  Customer c where c.pk = r.customer AND c.pk =:pk)")
    List<ReservationDto> getReservationsByCustomer(@Param("pk") Long pk);



}







