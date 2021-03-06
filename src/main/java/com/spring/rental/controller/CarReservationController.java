package com.spring.rental.controller;
import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.dto.ReservationDto;
import com.spring.rental.exceptionsCarReservation.*;
import com.spring.rental.service.CarReservationService;
import com.spring.rental.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class CarReservationController {

    @Autowired
   private CarReservationService carReservationService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/cars")
    public Set<CarReservationDto>  getAvailableCars(
          @RequestParam("pickUpDate") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate pickUpDate,
          @RequestParam("returnDate")  @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)  LocalDate returnDate) throws NoAvailableCarFound {

        return carReservationService.getAvailableCars(pickUpDate, returnDate);

    }

    @PostMapping(value = "/reservations")
    public void addReservation(ReservationDto reservationDto) throws ReturnDateBeforePickUpDateException,
            PickUpDateInThePastException,
            ReturnDateInThePastException,
            ReservationDatesException,
            NoAvailableCarFound,
            ReturnDateTooFarInTheFutureException {

        reservationService.addReservation(reservationDto);


    }

    @GetMapping(value = "/reservations")
    public List<ReservationDto> getReservationsByCustomer(@RequestParam("emailAddress")String emailAddress,
                                                          @RequestParam("firstName") String firstName,
                                                          @RequestParam("lastName") String lastName){
       return reservationService.getReservationsByCustomer(emailAddress, firstName, lastName);


    }
    }











