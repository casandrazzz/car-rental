package com.spring.rental.dto;

import com.spring.rental.enums.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
public class CustomerReservationDto {

    /**
     * DTO for reservation
     */
    private long id;
    private String location;
    private @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate pickUpDate;
    private @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate returnDate;

    private String vehicleMake;

    private String vehicleType;


}

