package com.spring.rental.dto;

import com.spring.rental.domain.Car;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
public class ReservationDto {

    private String location;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private List<Car> availableCars;
}
