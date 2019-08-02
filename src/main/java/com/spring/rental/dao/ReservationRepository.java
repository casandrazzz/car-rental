package com.spring.rental.dao;

import com.spring.rental.domain.Car;
import com.spring.rental.domain.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(value = "SELECT * FROM CAR c WHERE NOT EXISTS (" +
            "SELECT * FROM RESERVATION r" +
            "where c.pk_car = r.pk_car AND\n" +
            "//            pick_up_date < :pickUpDate AND\n" +
            "//           return_date > :returnDate )\n" +
            "//    AND c.rented = false)",
    nativeQuery = true)
    Set<Car> getAvailableCars(@Param("pickUpDate") LocalDate pickUpDate, @Param("returnDate") LocalDate returnDate);

}







