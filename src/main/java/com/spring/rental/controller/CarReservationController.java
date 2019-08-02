package com.spring.rental.controller;

import com.spring.rental.dao.CarRepository;
import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.service.CarReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/")
public class CarReservationController {

    @Autowired
   private CarReservationService carReservationService;

    @GetMapping("/showCars")
    public Set<CarReservationDto> home() {
        return carReservationService.getAvailableCars();
    }
}
