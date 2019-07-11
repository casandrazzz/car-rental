package com.spring.rental.domain;

import lombok.*;

import javax.persistence.*;


@Data
@ToString


@Entity
@Table(name = "car", schema = "public")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pk;

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

    public static class Builder extends Car {

        private long pk;
        private String transmission;
        private String vehicleType;
        private String vehicleMake;
        private String vehicleModel;
        private int seats;
        private boolean rented;

        public Builder pk(long pk) {
            this.pk = pk;

            return this;
        }

        public Builder transmission(String transmission) {
            this.transmission = transmission;

            return this;
        }

        public Builder vehicleType(String vehicleType) {
            this.vehicleType = vehicleType;

            return this;
        }

        public Builder vehicleMake(String vehicleMake) {
            this.vehicleMake = vehicleMake;

            return this;
        }

        public Builder vehicleModel(String vehicleModel) {
            this.vehicleModel = vehicleModel;

            return this;
        }

        public Builder seats(int seats) {
            this.seats = seats;

            return this;
        }

        public Builder rented(boolean rented) {
            this.rented = rented;

            return this;
        }

        public Car build() {

            Car car = new Car();
            car.setPk(this.pk);
            car.setTransmission(this.transmission);
            car.setVehicleType(this.vehicleType);
            car.setVehicleMake(this.vehicleMake);
            car.setVehicleModel(this.vehicleModel);
            car.setSeats(this.seats);
            car.setRented(this.rented);

            return car;


        }

    }


}
