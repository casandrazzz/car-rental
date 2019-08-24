package com.spring.rental.dto;

import com.spring.rental.domain.Car;
import com.spring.rental.domain.Customer;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Data
@ToString
public class ReservationDto {

    private String location;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private long pkCar;
    private long pk;
    //private Car car;
   // private Customer customer;
}
