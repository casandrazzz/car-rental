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

  // @Query("SELECT new com.spring.rental.dto.CarReservationDto(c.seats, c.transmission, c.vehicleMake, c.vehicleModel, c.vehicleType ) FROM Car c WHERE NOT EXISTS (SELECT r FROM Reservation r, Car c where c.pk = r.car AND pick_up_date < :pickUpDate AND return_date > :returnDate )")
  //  Set<CarReservationDto> getAvailableCarReservation(@Param("pickUpDate") LocalDate pickUpDate, @Param("returnDate") LocalDate returnDate);


    @Query(value = " SELECT c.*\\n\" +\n" +
            "            \"    FROM CAR AS c \\n\" +\n" +
            "            \"    LEFT JOIN (SELECT r.*\\n\" +\n" +
            "            \"            FROM reservation AS r\\n\" +\n" +
            "            \"            WHERE r.pick_up_date >= :pickUpDate and r.return_date <= :returnDate\\n\" +\n" +
            "            \"    )  AS r ON c.pkC = r.pk_car\\n\" +\n" +
            "            \"    WHERE r.pk_car is null AND c.transmission =:transmission AND c.vehicleType =:vehicleType",
    nativeQuery = true)
    List<CarFilterDto> filterAvailableCars (@Param("pickUpDate") LocalDate pickUpDate, @Param("returnDate") LocalDate returnDate, @Param("transmission") String transmission,
                                            @Param("vehicleType") String vehicleType
    );

    @Query(value = "SELECT * FROM Reservation r WHERE EXISTS (SELECT c FROM  Customer c where c.pkC = r.pk_user AND c.pkC =:pkC)",nativeQuery = true)
    List<Reservation> getReservationsByCustomer(@Param("pk") Long pkC);

    public Reservation findByLocation(String location);

}







