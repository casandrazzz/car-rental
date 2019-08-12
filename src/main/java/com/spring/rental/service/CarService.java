package com.spring.rental.service;

import com.spring.rental.dto.CarDto;
import com.spring.rental.exceptionsCarReservation.InvalidCarReservation;
import com.spring.rental.exceptionsCarReservation.NoAvailableCarFound;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface CarService {

    List<CarDto> findAll();

    void addCar(CarDto carDto) throws InvalidCarReservation;

    void deleteCar (long pk);

    void updateCar (long pk);

    Set<CarDto> getRentedCars();

    Set<CarDto> getAvailableCars(LocalDate pickUpdate, LocalDate returnDate) throws NoAvailableCarFound;
}
