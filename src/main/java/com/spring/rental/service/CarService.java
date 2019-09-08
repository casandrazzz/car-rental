package com.spring.rental.service;

import com.spring.rental.dto.CarDto;

import java.util.List;

public interface CarService {

    List<CarDto> findAll();

    void delete(long pk);

    CarDto findById(Long id);

    Long save(CarDto car);

}
