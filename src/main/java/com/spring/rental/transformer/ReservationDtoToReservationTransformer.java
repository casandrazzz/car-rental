package com.spring.rental.transformer;
import com.spring.rental.domain.Reservation;
import com.spring.rental.dto.ReservationDto;


public class ReservationDtoToReservationTransformer {

    public static Reservation transform(ReservationDto reservationDto){

        Reservation reservation = new Reservation( );
        reservation.setCar(reservation.getCar());
        reservation.setCustomer(reservation.getCustomer());
        reservation.setPk(reservation.getPk());
        reservation.setLocation(reservation.getLocation());
        reservation.setPickUpDate(reservation.getPickUpDate());
        reservation.setReturnDate(reservation.getReturnDate());
    return reservation;
    }

    }


