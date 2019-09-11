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

import java.math.BigInteger;
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



    @Query(value = "  SELECT * FROM CAR  c LEFT JOIN (SELECT * FROM reservation  r WHERE r.pick_up_date >= :pickUpDate and r.return_date <= :returnDate)  AS r ON c.pkC = r.pk_car WHERE r.pk_car is null",
            nativeQuery = true)
    Set<Long> getAvailableCars(@Param("pickUpDate") LocalDate pickUpDate, @Param("returnDate") LocalDate returnDate);

    @Query(value = "SELECT * FROM CAR c WHERE NOT EXISTS (SELECT * FROM RESERVATION r where c.pkC = r.pk_car AND r.pick_up_date < :pickUpDate AND r.return_date > :returnDate ) AND UPPER(c.transmission) =UPPER(:transmission) AND UPPER(c.vehicle_type) =UPPER(:vehicleType)",
    nativeQuery = true)
    List<Long> filterAvailableCars (@Param("pickUpDate") LocalDate pickUpDate, @Param("returnDate") LocalDate returnDate, @Param("transmission") String transmission,
                                            @Param("vehicleType") String vehicleType );

    @Query(value = "SELECT * FROM Reservation r WHERE EXISTS (SELECT c FROM  Customer c where c.pk = r.pk_user AND UPPER(c.email_address) =UPPER(:emailAddress) AND UPPER(c.first_name) =UPPER(:firstName) AND UPPER(c.last_name) =UPPER(:lastName))",nativeQuery = true)
    List<Long> getReservationsByCustomer(@Param("emailAddress") String emailAddres,
                                                @Param("firstName") String firstName,
                                                @Param("lastName") String lastName);

    Reservation findByLocation(String location);
}







