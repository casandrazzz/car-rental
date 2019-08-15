package com.spring.rental.service;

import com.spring.rental.dto.CarDto;
import com.spring.rental.exceptions.reservationExceptions.NoAvailableCarFound;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface CarService {

    List<CarDto> findAll();

    void delete(long pk);

    Set<CarDto> getRentedCars();

    Set<CarDto> getAvailableCars(LocalDate pickUpdate, LocalDate returnDate) throws NoAvailableCarFound;

    CarDto findById(Long id);

    Long save(CarDto car);
}
