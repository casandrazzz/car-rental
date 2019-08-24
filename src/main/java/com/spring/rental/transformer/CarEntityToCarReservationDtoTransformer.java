package com.spring.rental.transformer;

import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarReservationDto;

public class CarEntityToCarReservationDtoTransformer {

    public static CarReservationDto transform(Car car){

        CarReservationDto carReservationDto = new CarReservationDto();
        carReservationDto.setTransmission(String.valueOf(car.getTransmission()));
        carReservationDto.setVehicleMake(String.valueOf(car.getVehicleMake()));
        carReservationDto.setVehicleModel(car.getVehicleModel());
        carReservationDto.setVehicleType(String.valueOf(car.getVehicleType()));
        carReservationDto.setSeats(car.getSeats());

        return carReservationDto;
    }
}
