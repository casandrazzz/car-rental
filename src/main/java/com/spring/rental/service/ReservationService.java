package com.spring.rental.service;

import com.spring.rental.dto.CustomerReservationDto;
import com.spring.rental.dto.ReservationDto;
import com.spring.rental.enums.VehicleType;
import com.spring.rental.exceptionsCarReservation.*;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    /**
     * interface for ReservationService implementation
     * @param reservationDto

     */

    void addReservation(ReservationDto reservationDto) ;
    void deleteReservation(long pk);
    void updateReservation();
    List<CustomerReservationDto> getReservationsByCustomer(String emailAddress, String firstName, String lastName);

    long calculateReservationCost(LocalDate pickUpDate, LocalDate returnDate, VehicleType vehicleType) throws ReservationDatesException, ReturnDateBeforePickUpDateException, PickUpDateInThePastException, ReturnDateInThePastException, ReturnDateTooFarInTheFutureException;
}
