package com.spring.rental.transformer;
import com.spring.rental.domain.Reservation;
import com.spring.rental.dto.ReservationDto;


public class ReservationDtoToReservationTransformer {
    /**
     * transform reservation DTO to reservation Object
     * @param reservationDto        reservation DTO
     * @return                      reservation Object
     */

    public static Reservation transform(ReservationDto reservationDto){

        Reservation reservation = new Reservation( );
       // reservation.setCar(reservationDto.getCar());
       // reservation.setCustomer(reservationDto.getCustomer());
        reservation.setLocation(reservationDto.getLocation());
        reservation.setPickUpDate(reservationDto.getPickUpDate());
        reservation.setReturnDate(reservationDto.getReturnDate());
    return reservation;
    }

    }

