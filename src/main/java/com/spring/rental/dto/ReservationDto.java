package com.spring.rental.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
public class ReservationDto {

    /**
     * DTO for reservation
     */

    private String location;
    private @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate pickUpDate;
    private @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate returnDate;
    private long pkCar;
    private long pkCostumer;

    public ReservationDto(String location, LocalDate pickUpDate,LocalDate returnDate,long pkCar, long pkCostumer) {
        this.location = location;
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.pkCar = pkCar;
        this.pkCostumer = pkCostumer;
    }
}
