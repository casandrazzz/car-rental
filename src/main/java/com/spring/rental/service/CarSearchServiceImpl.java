package com.spring.rental.service;

import com.spring.rental.dao.CarRepository;
import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.exceptionsCarReservation.NoAvailableCarFound;
import com.spring.rental.searchForCar.CarSearchResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.spring.rental.exceptionsCarReservation.CodesCarReservation.NO_AVAILABLE_CAR_FOUND;

@Service
public class CarSearchServiceImpl implements CarSearchService {


    @Autowired
    private CarRepository carRepository;


    public CarSearchServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarSearchResults<CarReservationDto> search(String vehicleType,
                                                      String vehicleMake,
                                                      String transmission,
                                                      Integer seats) throws NoAvailableCarFound {


        Set<Car> results = new HashSet<>();

        if (vehicleType != null) {
            results = carRepository.searchCarsByType(vehicleType);
        } else if (vehicleMake != null) {
            results = carRepository.searchCarsByMake(vehicleMake);
        } else if (transmission != null) {
            results = carRepository.searchCarsByTransmission(transmission);
        }else if (seats != null)
            results = carRepository.searchCarsBySeats(seats);

        CarSearchResults<CarReservationDto> searchResults = new CarSearchResults<>();


        if (results.isEmpty()){
            throw new NoAvailableCarFound("Sorry, no available cars were found.", NO_AVAILABLE_CAR_FOUND);
        }
        return searchResults;
    }
    }

