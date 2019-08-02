package com.spring.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarReservationDto {

    private String transmission;
    private String vehicleType;
    private String vehicleMake;
    private String vehicleModel;
    private int seats;



}
