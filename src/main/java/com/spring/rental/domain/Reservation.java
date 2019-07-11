package com.spring.rental.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data

@Entity
@Table(name = "reservation", schema = "public")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pk;

    @Column (name = "location")
    private String location;

    @Column (name = "pickUpDate")
    private LocalDate pickUpDate;

    @Column (name = "returnDate")
    private LocalDate returnDate;

    @Column (name = "rentalPeriod")
    private int rentalPeriod;

    @Column (name = "rented")
    private final boolean rented;

    // add customer and car here
    @Column (name = "CarId")
    private long CarId;

    @Column (name = "UserId")
    private long UserId;
}
