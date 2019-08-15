package com.spring.rental.controller;

import com.spring.rental.dto.CarDto;
import com.spring.rental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}/edit")
    public ModelAndView getEdit(@PathVariable("id") Long id,
                                ModelAndView mav) {
        CarDto car = carService.findById(id);

        mav.addObject("car", car);
        mav.setViewName("car-management/save");
        return mav;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("car") CarDto car){
        carService.save(car);
        return new ModelAndView("redirect:/car/list");
    }

    @GetMapping("/create")
    public ModelAndView getCreate(ModelAndView mav,
                                  CarDto car) {
        mav.addObject("car", car);
        mav.setViewName("car-management/save");
        return mav;
    }

    @ResponseBody
    @PostMapping("/{id}/delete")
    public void delete(@PathVariable("id") Long id) {
        carService.delete(id);
    }
}
