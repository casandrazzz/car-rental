package com.spring.rental.service;

import com.spring.rental.domain.Reservation;
import com.spring.rental.dto.ReservationDto;

import java.util.List;

public interface ReservationService {

    void addReservation(ReservationDto reservationDto);
    void deleteReservation(long pk);
    List<Reservation> getReservations();

}
