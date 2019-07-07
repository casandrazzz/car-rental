package com.spring.rental.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data

@Entity
@Table(name = "reservation", schema = "public")
public class Reservation extends AbstractModel {
    private String location;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private int rentalPeriod;
    private final boolean rented;

    // add customer and car here
}
