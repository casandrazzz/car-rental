package com.spring.rental.service;

import com.spring.rental.domain.Reservation;
import com.spring.rental.dto.ReservationDto;
import com.spring.rental.exceptionsCarReservation.*;
import org.joda.time.LocalDate;

import java.util.List;

public interface ReservationService {
    /**
     * interface for ReservationService implementation
     * @param reservationDto
     * @throws ReservationDatesException
     * @throws ReturnDateBeforePickUpDateException
     * @throws PickUpDateInThePastException
     * @throws ReturnDateInThePastException
     * @throws ReturnDateTooFarInTheFutureException
     * @throws NoAvailableCarFound
     */

    void addReservation(ReservationDto reservationDto) throws ReservationDatesException, ReturnDateBeforePickUpDateException, PickUpDateInThePastException, ReturnDateInThePastException, ReturnDateTooFarInTheFutureException, NoAvailableCarFound;
    void deleteReservation(long pk);
    void updateReservation();
    List<ReservationDto> getReservationsByCustomer(long pk);

    long calculateReservationCost(ReservationDto reservationDto, String vehicleType) throws ReservationDatesException, ReturnDateBeforePickUpDateException, PickUpDateInThePastException, ReturnDateInThePastException, ReturnDateTooFarInTheFutureException;
}
