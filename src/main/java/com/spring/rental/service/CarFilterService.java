package com.spring.rental.service;

import com.spring.rental.dao.ReservationRepository;
import com.spring.rental.dto.CarFilterDto;
import com.spring.rental.exceptionsCarReservation.NoAvailableCarFound;
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
     by vehicle type


     * @param pickUpDate       the pick-up date of the car
     * @param returnDate       the return date of the car
     * @param transmission     the selected transmission of the car
     * @param vehicleType      the selected vehicle type
     * @return filtered list of available cars

     */

    @Autowired
    private ReservationRepository reservationRepository;

    public List<CarFilterDto> filterAvailableCars(LocalDate pickUpDate, LocalDate returnDate,
                                                  String transmission, String vehicleType) {
        List<CarFilterDto> filterCars = new ArrayList<>();
        //Predicate<CarFilterDto> isAutomaticTransmission = e -> e.getTransmission().equalsIgnoreCase("Automatic");


        List<CarFilterDto> cars = reservationRepository.filterAvailableCars(pickUpDate, returnDate, transmission, vehicleType);

        for (CarFilterDto car : cars) {

            CarFilterDto carFilterDto = new CarFilterDto();
            carFilterDto.setPkCar(car.getPkCar());
            carFilterDto.setTransmission(car.getTransmission());
            carFilterDto.setVehicleMake(car.getVehicleMake());
            carFilterDto.setVehicleType(car.getVehicleType());
            carFilterDto.setSeats(car.getSeats());


            filterCars.add(carFilterDto);

        }


        //    List<CarFilterDto> result = new ArrayList<>();
        //    for (CarFilterDto carFilterDto : listForFilter) {
        //        if (automaticTransmission.test(carFilterDto)) {
        //            result.add(carFilterDto);
        //        }
        //   }

        if (filterCars.isEmpty()) {
            try {
                throw new NoAvailableCarFound("Sorry, no available cars were found.", NO_AVAILABLE_CAR_FOUND);
            } catch (NoAvailableCarFound noAvailableCarFound) {
                noAvailableCarFound.printStackTrace();
            }


            // }
            //   return  listForFilter.stream()
            //           .filter(isAutomaticTransmission)
            //           .collect(Collectors.toList());
            // }

        }
        return filterCars;
    }
}


















