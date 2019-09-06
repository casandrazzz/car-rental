package com.spring.rental.transformer;

import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarReservationDto;

public class CarEntityToCarReservationDtoTransformer {
    /**
     * transforms entity to DTO
     * @param car       car Object
     * @return          car DTO
     */

    public static CarReservationDto transform(Car car){

        CarReservationDto carReservationDto = new CarReservationDto();
        carReservationDto.setTransmission(car.getTransmission());
        carReservationDto.setVehicleMake(car.getVehicleMake());
        carReservationDto.setVehicleModel(car.getVehicleModel());
        carReservationDto.setVehicleType(car.getVehicleType());
        carReservationDto.setSeats(car.getSeats());

        return carReservationDto;
    }
}
