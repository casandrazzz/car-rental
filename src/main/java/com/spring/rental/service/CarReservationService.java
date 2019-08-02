package com.spring.rental.service;

import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.exceptions.InvalidCarReservation;

import java.time.LocalDate;
import java.util.Set;

public interface CarReservationService {

    void addCar(CarReservationDto carReservationDto) throws InvalidCarReservation;
    void deleteCar (long pk);
    void updateCar (long pk);
    Set<CarReservationDto> getRentedCars();
    Set<CarReservationDto> getAvailableCars(LocalDate pickUpdate, LocalDate returnDate);

}
