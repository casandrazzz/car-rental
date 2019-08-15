package com.spring.rental.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Data
@ToString
@Entity
@Table(name = "car", schema = "public")
public class Car {

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    @Column(name = "rented")
    private boolean rented;

    @Column(name = "price")
    private Double price;

    public Car() {
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
