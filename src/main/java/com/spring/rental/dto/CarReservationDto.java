package com.spring.rental.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarReservationDto {

    /**
     * DTO for car reservation
     */

    private String transmission;
    private String vehicleType;
    private String vehicleMake;
    private String vehicleModel;
    private int seats; ;



}
