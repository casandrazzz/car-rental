package com.spring.rental.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data

@Entity
@Table(name = "reservation", schema = "public")
public class Reservation {

    @ManyToOne
    @JoinColumn(name = "pkCar", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "pkUser", nullable = false)
    private Customer customer;

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
    private boolean rented;

    // add customer and car here

    public Reservation() {
    }
}
