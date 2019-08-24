package com.spring.rental.dao;

import com.spring.rental.domain.Car;
import com.spring.rental.domain.Reservation;

import com.spring.rental.dto.CarReservationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(value = "SELECT * FROM CAR c WHERE NOT EXISTS (SELECT * FROM RESERVATION r where c.pk_car = r.pk_car AND pick_up_date < :pickUpDate AND return_date > :returnDate )" +
            "AND c.rented = false;",
    nativeQuery = true)
    Set<Car> getAvailableCars(@Param("pickUpDate") LocalDate pickUpDate, @Param("returnDate") LocalDate returnDate);


    @Query("SELECT new com.spring.rental.dto.CarReservationDto(c.vehicleType, c.vehicleMake, c.vehicleModel, c.transmission, c.seats) FROM Car c WHERE NOT EXISTS (SELECT r FROM Reservation r, Car c where c.pkCar = r.car AND pick_up_date < :pickUpDate AND return_date > :returnDate )"+
            "AND c.rented = false")
    Set<CarReservationDto> getAvailableCarReservationDto(@Param("pickUpDate") LocalDate pickUpDate, @Param("returnDate") LocalDate returnDate);

  //  @Query(value = "CREATE PROCEDURE add_reservation" +
  //          "AS" +
  //          "INSERT into RESERVATION r(location, pick_up_date, return_date, pk_car, pk_user)" +
  //          "VALUES(location,pick_up_date,return_date,(SELECT pk_car FROM car c where c.pk_car = r.pk_car),(SELECT pk FROM customer u where u.pk = r.pk_user )" +
  //          "UPDATE c.rented = true where c.pk_car = r.pk_car AND r.rented = true " +
  //          "GO;" +
  //          "EXEC add_reservation;)",
  //          nativeQuery = true)




}







