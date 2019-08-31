package com.spring.rental.dto;

import com.spring.rental.enums.NumberOfSeats;
import com.spring.rental.enums.VehicleMake;
import com.spring.rental.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarFilterDto {

    /**
     * DTO for filtering list of available cars by transmission and vehicle type
     */

    private long pkCar;
    private java.lang.String transmission;
    private String vehicleType;
    private java.lang.String vehicleMake;
    private int seats;
}
