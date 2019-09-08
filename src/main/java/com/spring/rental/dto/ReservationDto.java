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
public class ReservationDto {

    /**
     * DTO for reservation
     */

    private String location;
    private @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate pickUpDate;
    private @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate returnDate;

    private long pkC;
    private long pkCostumer;

}
