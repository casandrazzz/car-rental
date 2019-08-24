package com.spring.rental.service;

import com.spring.rental.dao.ReservationRepository;
import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.exceptionsCarReservation.NoAvailableCarFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static com.spring.rental.exceptionsCarReservation.CodesCarReservation.NO_AVAILABLE_CAR_FOUND;


@Service
public class CarReservationServiceImpl implements CarReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

           @Override
    public Set<CarReservationDto> getAvailableCars(LocalDate pickUpDate, LocalDate returnDate) throws NoAvailableCarFound {
               Set<CarReservationDto> availableCars = new HashSet<>();


               Set<Car> cars = reservationRepository.getAvailableCars(pickUpDate, returnDate );
               for (Car car : cars) {

                   CarReservationDto carReservationDto = new CarReservationDto();
                   carReservationDto.setTransmission(car.getTransmission());
                   carReservationDto.setVehicleMake(car.getVehicleMake());
                   carReservationDto.setVehicleModel(car.getVehicleModel());
                   carReservationDto.setVehicleType(car.getVehicleType());
                   carReservationDto.setSeats(car.getSeats());


                   availableCars.add(carReservationDto);
                   if (availableCars.isEmpty()) {
                       throw new NoAvailableCarFound("Sorry, no available cars were found.", NO_AVAILABLE_CAR_FOUND);
                   }


               }
               return availableCars;

           }

    @Override
    public Set<CarReservationDto> getAvailableCarReservationDto(LocalDate pickUpDate, LocalDate returnDate) {
        Set<CarReservationDto> availableCars = new HashSet<>();


        Set<CarReservationDto> cars = reservationRepository.getAvailableCarReservationDto(pickUpDate, returnDate);
        for (CarReservationDto car : cars) {

            CarReservationDto carReservationDto = new CarReservationDto();
            carReservationDto.setTransmission(car.getTransmission());
            carReservationDto.setVehicleMake(car.getVehicleMake());
            carReservationDto.setVehicleModel(car.getVehicleModel());
            carReservationDto.setVehicleType(car.getVehicleType());
            carReservationDto.setSeats(car.getSeats());


            availableCars.add(carReservationDto);
            if (availableCars.isEmpty()) {
                try {
                    throw new NoAvailableCarFound("Sorry, no available cars were found.", NO_AVAILABLE_CAR_FOUND);
                } catch (NoAvailableCarFound noAvailableCarFound) {
                    noAvailableCarFound.printStackTrace();
                }
            }


        }
        return availableCars;

    }


}




















