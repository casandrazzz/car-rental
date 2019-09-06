package com.spring.rental.service;

import com.spring.rental.dao.CarRepository;
import com.spring.rental.dao.ReservationRepository;
import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.exceptionsCarReservation.NoAvailableCarFound;
import com.spring.rental.transformer.CarEntityToCarReservationDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.spring.rental.exceptionsCarReservation.CodesCarReservation.NO_AVAILABLE_CAR_FOUND;


@Service
public class CarReservationServiceImpl implements CarReservationService {

    /** implements CarReservationSerrvice interface
     * gets available cars according to the specified pick-up date and return date
     * @param pickUpDate        pick-up date for the car
     * @param returnDate        return date for the car
     * @return list of available cars in the selected date interval
     */

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ReservationRepository reservationRepository;

           @Override
    public Set<CarReservationDto> getAvailableCars(LocalDate pickUpDate, LocalDate returnDate) throws NoAvailableCarFound {
              Set<CarReservationDto> availableCars = new HashSet<>();


               Set<Long> cars = reservationRepository.getAvailableCars(pickUpDate, returnDate);

               Set<Car> cars2 = new HashSet<>();
               for (Long car : cars) {
                 Car carId = carRepository.findById(car).get();
                 cars2.add(carId);}

               for (Car car: cars2){
                CarReservationDto carReservationDto = new CarReservationDto();
                 carReservationDto.setTransmission(car.getTransmission());
               carReservationDto.setVehicleMake(car.getVehicleMake());
                 carReservationDto.setVehicleModel(car.getVehicleModel());
                carReservationDto.setVehicleType(car.getVehicleType());
                carReservationDto.setSeats(car.getSeats());


                  availableCars.add(carReservationDto);
                 if (cars.isEmpty()) {
                      throw new NoAvailableCarFound("Sorry, no available cars were found.", NO_AVAILABLE_CAR_FOUND);
                  }


             }
              return availableCars;

          }

    @Override
    public Set<CarReservationDto> getAvailableCarReservation(LocalDate pickUpDate, LocalDate returnDate) {
        return null;
    }


}




















