package com.spring.rental.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Data
@ToString

@Entity
@Table(name = "car", schema = "public")
public class Car extends AbstractModel{
   // private String location;
   // private LocalDate pickUpDate;
   // private LocalDate returnDate;
   // private int rentalPeriod;

    private String transmission;
    private String vehicleType;
    private String vehicleMake;
    private String vehicleModel;
    private int seats;
    private boolean rented;


}
