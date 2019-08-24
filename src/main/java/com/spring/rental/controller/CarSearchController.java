package com.spring.rental.controller;

import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.exceptionsCarReservation.NoAvailableCarFound;
import com.spring.rental.searchForCar.CarSearchCriteria;
import com.spring.rental.searchForCar.CarSearchResults;
import com.spring.rental.service.CarSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class CarSearchController {

    @Autowired
    private CarSearchService carSearchService;



    @PostMapping("/searchCars")
    public CarSearchResults<CarReservationDto> search(String vehicleType,
                                                      String vehicleMake,
                                                      String transmission,
                                                      Integer seats) throws NoAvailableCarFound {
        return carSearchService.search(vehicleType,vehicleMake,transmission,seats );
    }

}
