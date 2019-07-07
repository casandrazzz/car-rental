package com.spring.rental.service;

import com.spring.rental.dao.ReservationRepository;
import com.spring.rental.domain.Reservation;

import java.util.Collection;

public class ReservationService {

    ReservationRepository reservationRepository;

    Collection<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    Reservation findById(Long id){
        return reservationRepository.findById(id);
    }

    Reservation update(Reservation reservation){
        return reservationRepository.update(reservation);
    }

    boolean delete(Reservation reservation){
        return reservationRepository.delete(reservation);
    }
}
