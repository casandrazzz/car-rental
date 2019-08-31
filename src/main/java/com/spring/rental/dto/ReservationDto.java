package com.spring.rental.dto;

import com.spring.rental.domain.Car;
import com.spring.rental.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {

    /**
     * DTO for reservation
     */

    private String location;
    private @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate pickUpDate;
    private @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate returnDate;
    private long pkCar;
    private long pk;
    private Car car;
    private Customer customer;

    public ReservationDto(String location, LocalDate pickUpDate,LocalDate returnDate,Car car, long pk) {
        this.location = location;
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.car = car;
        this.pk = pk;
    }


    public ReservationDto(String location, LocalDate pickUpDate,LocalDate returnDate,Customer customer, long pk) {
        this.location = location;
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.customer = customer;
        this.pk = pk;
    }
}
