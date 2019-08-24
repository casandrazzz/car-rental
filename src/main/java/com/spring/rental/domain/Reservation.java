package com.spring.rental.domain;

import com.spring.rental.service.ReservationService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

import static org.joda.time.Days.daysBetween;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reservation", schema = "public")
public class Reservation {

    @Autowired
    private static ReservationService reservationService;

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
    public int rentalPeriod;


  //  @Column (name = "rentalTax")
  //  public long rentalTax;

    @Column (name = "rented")
    private boolean rented;


}
