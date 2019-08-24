package com.spring.rental.dto;

import com.spring.rental.enums.NumberOfSeats;
import com.spring.rental.enums.Transmission;
import com.spring.rental.enums.VehicleMake;
import com.spring.rental.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarReservationDto {

    private String transmission;
    private String vehicleType;
    private String vehicleMake;
    private String vehicleModel;
    private int seats; ;



}
