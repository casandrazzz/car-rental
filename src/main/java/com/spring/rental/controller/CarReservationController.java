package com.spring.rental.controller;
import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.dto.CustomerReservationDto;
import com.spring.rental.dto.ReservationDto;
import com.spring.rental.enums.VehicleType;
import com.spring.rental.exceptionsCarReservation.*;
import com.spring.rental.service.CarReservationService;
import com.spring.rental.service.ReservationService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
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
          @RequestParam("returnDate")  @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)  LocalDate returnDate) throws NoAvailableCarFound, ReservationDatesException, ReturnDateBeforePickUpDateException, PickUpDateInThePastException, ReturnDateInThePastException, ReturnDateTooFarInTheFutureException {

        return carReservationService.getAvailableCars(pickUpDate, returnDate);

    }

    @PostMapping(value = "/reservations",
    consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void addReservation(@RequestBody ReservationDto reservationDto) throws ReturnDateBeforePickUpDateException,
            PickUpDateInThePastException,
            ReturnDateInThePastException,
            ReservationDatesException,
            NoAvailableCarFound,
            ReturnDateTooFarInTheFutureException {

        reservationService.addReservation(reservationDto);


    }

    @GetMapping(value = "/reservations")
    public List<CustomerReservationDto> getReservationsByCustomer(@RequestParam("emailAddress")String emailAddress,
                                                                  @RequestParam("firstName") String firstName,
                                                                  @RequestParam("lastName") String lastName){
       return reservationService.getReservationsByCustomer(emailAddress, firstName, lastName);


    }
    @DeleteMapping(value ="/reservations/{id}")
    public void deleteReservation(@PathVariable("id") long id) {
        reservationService.deleteReservation(id);
    }

    @GetMapping(value ="/reservations/price")
    public long calculatePrice(@RequestParam("pickUpDate") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate pickUpDate,
                               @RequestParam("returnDate") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate returnDate,
                               @RequestParam("vehicleType")VehicleType vehicleType) throws ReservationDatesException, ReturnDateBeforePickUpDateException, PickUpDateInThePastException, ReturnDateInThePastException, ReturnDateTooFarInTheFutureException {
        return reservationService.calculateReservationCost(pickUpDate, returnDate, vehicleType);
    }
    }











