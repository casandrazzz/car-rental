package com.spring.rental.service;

import com.spring.rental.dao.CarRepository;
import com.spring.rental.dao.CustomerRepository;
import com.spring.rental.dao.ReservationRepository;
import com.spring.rental.domain.Car;
import com.spring.rental.domain.Customer;
import com.spring.rental.domain.Reservation;
import com.spring.rental.dto.ReservationDto;
import com.spring.rental.exceptionsCarReservation.*;
import com.spring.rental.transformer.ReservationDtoToReservationTransformer;
import com.spring.rental.validation.ReservationDatesValidation;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;



   // public long calculateReservationCost() {

    //    int reservationPrice = 50;

     //   if (Reservation.rentalPeriod >= 5)
     //       return (long) (Reservation.rentalTax * reservationPrice * 0.5);
    //    else {
    //        return Reservation.rentalTax * reservationPrice;


    //    }
  //  }

    @Override
    public void addReservation(ReservationDto reservationDto,
                               Long pkCar, Long pk) throws ReservationDatesException,
            ReturnDateBeforePickUpDateException,
            PickUpDateInThePastException,
            ReturnDateInThePastException,
            ReturnDateTooFarInTheFutureException {


        ReservationDatesValidation.validateReservationDates(reservationDto);

        Car car = carRepository.findById(reservationDto.getPkCar()).get();
        Customer customer = customerRepository.findById(reservationDto.getPk()).get();

        Reservation reservation = ReservationDtoToReservationTransformer.transform(reservationDto);

        reservation.setCar(car);
        reservation.setCustomer(customer);

        reservationRepository.save(reservation);

   }

    @Override
    public void deleteReservation(long pk) {

    }

    @Override
    public void updateReservation() {

    }

    @Override
    public List<Reservation> getReservations() {
        return null;
    }
}

