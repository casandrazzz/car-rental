package com.spring.rental.service;

import com.spring.rental.domain.Reservation;
import com.spring.rental.dto.ReservationDto;
import com.spring.rental.exceptionsCarReservation.*;
import org.joda.time.LocalDate;

import java.util.List;

public interface ReservationService {

    void addReservation(ReservationDto reservationDto, Long pkCar, Long pk) throws ReservationDatesException, ReturnDateBeforePickUpDateException, PickUpDateInThePastException, ReturnDateInThePastException, ReturnDateTooFarInTheFutureException, NoAvailableCarFound;
    void deleteReservation(long pk);
    void updateReservation();
    List<Reservation> getReservations();

  //  long calculateReservationCost();
}
