package com.spring.rental.controller;



import com.spring.rental.dto.CarFilterDto;
import com.spring.rental.enums.Transmission;
import com.spring.rental.enums.VehicleType;
import com.spring.rental.exceptionsCarReservation.*;
import com.spring.rental.service.CarFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class CarFilterController {

    @Autowired
    private CarFilterService carFilterService;



    @ModelAttribute
    LocalDate initLocalDate() {
        return LocalDate.now();
    }


    @PostMapping("/filter")
    public List<CarFilterDto> filterAvailableCars(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ModelAttribute LocalDate pickUpDate,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ModelAttribute LocalDate returnDate,
            Transmission transmission, VehicleType vehicleType) throws ReservationDatesException, ReturnDateBeforePickUpDateException, PickUpDateInThePastException, ReturnDateInThePastException, ReturnDateTooFarInTheFutureException {

        return carFilterService.filterAvailableCars(pickUpDate, returnDate, transmission.toString(), vehicleType.toString());

    }

}
