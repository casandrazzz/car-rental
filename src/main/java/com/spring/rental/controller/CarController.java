package com.spring.rental.controller;

import com.spring.rental.dto.CarDto;
import com.spring.rental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(final CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/list")
    public ModelAndView getCars(ModelAndView mav) {
        List<CarDto> cars = carService.findAll();

        mav.addObject("cars", cars);
        mav.setViewName("car-management/list");
        return mav;
    }
}
