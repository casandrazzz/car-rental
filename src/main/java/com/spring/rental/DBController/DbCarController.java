package com.spring.rental.DBController;

import com.spring.rental.dao.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class DbCarController {

    @Autowired
    CarRepository carRepository;

    //@PostMapping("/bulkcreate")
   // public String bulkcreate

}
