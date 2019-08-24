package com.spring.rental.service;

import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.exceptionsCarReservation.NoAvailableCarFound;
import com.spring.rental.searchForCar.CarSearchCriteria;
import com.spring.rental.searchForCar.CarSearchResults;

import java.time.LocalDate;

public interface CarSearchService {

    CarSearchResults<CarReservationDto> search(
                                               String vehicleType,
                                               String vehicleMake,
                                               String transmission,
                                               Integer seats) throws NoAvailableCarFound;
}

