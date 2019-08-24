package com.spring.rental.domain;

import com.spring.rental.enums.NumberOfSeats;
import com.spring.rental.enums.Transmission;
import com.spring.rental.enums.VehicleMake;
import com.spring.rental.enums.VehicleType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car", schema = "public")
public class Car {
    @OneToMany(mappedBy="car", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pkCar;

   @Column (name = "transmission")
    private String transmission;

   @Column (name = "vehicleType")
    private String vehicleType;

   @Column (name = "vehicleMake")
    private String vehicleMake;

   @Column (name = "vehicleModel")
    private String vehicleModel;

   @Column (name = "seats")
    private int seats;

   @Column (name = "rented")
    private boolean rented;



        }





