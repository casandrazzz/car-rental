package com.spring.rental.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data

@Entity
@Table(name = "reservation", schema = "public")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pk;

    private String location;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private int rentalPeriod;
    private final boolean rented;
}
