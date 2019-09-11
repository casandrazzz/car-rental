package com.spring.rental.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
public class CarReservationDto {

    /**
     * DTO for car reservation
     */


    private String transmission;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleType;
    private int seats;
    private long id;

    public CarReservationDto(String vehicleType, String vehicleMake, String vehicleModel, String transmission, int seats){
        this.vehicleType = vehicleType;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.transmission = transmission;
        this.seats = seats;
    }


}
