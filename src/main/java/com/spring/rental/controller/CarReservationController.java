package com.spring.rental.controller;
import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.dto.ReservationDto;
import com.spring.rental.exceptionsCarReservation.*;
import com.spring.rental.service.CarReservationService;
import com.spring.rental.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @ModelAttribute
    LocalDate initLocalDate() {
        return LocalDate.now();
    }


    @PostMapping("/cars")
    public Set<CarReservationDto>  getAvailableCarReservationDto(
            @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)  @ModelAttribute LocalDate pickUpDate,
            @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)  @ModelAttribute LocalDate returnDate) {

        return carReservationService.getAvailableCarReservationDto(pickUpDate, returnDate);

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

    @PostMapping(value = "/reservations/spec")
    public List<ReservationDto> getReservationsByCustomer(long pk){
       return reservationService.getReservationsByCustomer(pk);


    }
    }











