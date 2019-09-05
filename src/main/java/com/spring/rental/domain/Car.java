package com.spring.rental.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "car", schema = "public")
public class Car {

    /**
     * Car table, joined with Reservation table
     */
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pkC;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "vehicleType")
    private String vehicleType;

    @Column(name = "vehicleMake")
    private String vehicleMake;

    @Column(name = "vehicleModel")
    private String vehicleModel;

    @Column(name = "seats")
    private int seats;

   // public Car(long pk, int seats, String vehicleMake, String vehicleModel, String vehicleType) {
   //     this.pk = pk;
   //     this.seats = seats;
   //     this.vehicleMake = vehicleMake;
   //     this.vehicleModel = vehicleModel;
   //     this.vehicleType = vehicleType;


   // }
}





