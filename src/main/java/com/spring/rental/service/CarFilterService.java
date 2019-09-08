package com.spring.rental.service;

import com.spring.rental.dao.CarRepository;
import com.spring.rental.dao.ReservationRepository;
import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarFilterDto;
import com.spring.rental.exceptionsCarReservation.*;
import com.spring.rental.validation.ReservationDatesValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.spring.rental.exceptionsCarReservation.CodesCarReservation.NO_AVAILABLE_CAR_FOUND;

@Service
public class CarFilterService {

    /** filters available cars list by transmission(automatic/manual) and
     by vehicle type and calculates price by type


     * @param pickUpDate       the pick-up date of the car
     * @param returnDate       the return date of the car
     * @param transmission     the selected transmission of the car
     * @param vehicleType      the selected vehicle type
     * @return filtered list of available cars

     */

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CarRepository carRepository;

    public List<CarFilterDto> filterAvailableCars(LocalDate pickUpDate, LocalDate returnDate,
                                                  String transmission, String vehicleType) throws ReservationDatesException, ReturnDateBeforePickUpDateException, PickUpDateInThePastException, ReturnDateInThePastException, ReturnDateTooFarInTheFutureException {


        CarFilterDto carFilterDto = null;
        ReservationDatesValidation.validateReservationDates(pickUpDate, returnDate);
        List<CarFilterDto> filterCars = new ArrayList<>();
        //Predicate<CarFilterDto> isAutomaticTransmission = e -> e.getTransmission().equalsIgnoreCase("Automatic");

        List<Long> cars = reservationRepository.filterAvailableCars(pickUpDate, returnDate, transmission, vehicleType);

        List<Car> carList = new ArrayList<>();
        for (Long car : cars) {
            Car carId = carRepository.findById(car).get();
            carList.add(carId);
        }

        for (Car car : carList) {

            carFilterDto = new CarFilterDto();
            carFilterDto.setPkCar(car.getPkC());
            carFilterDto.setTransmission(car.getTransmission());
            carFilterDto.setVehicleMake(car.getVehicleMake());
            carFilterDto.setVehicleType(car.getVehicleType());
            carFilterDto.setSeats(car.getSeats());


            filterCars.add(carFilterDto);

        }

        if (filterCars.isEmpty()) {
            try {
                throw new NoAvailableCarFound("Sorry, no available cars were found.", NO_AVAILABLE_CAR_FOUND);
            } catch (NoAvailableCarFound noAvailableCarFound) {
                noAvailableCarFound.printStackTrace();
            }


        }
        return filterCars;
    }
}


















