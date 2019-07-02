package com.spring.rental.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter

@Entity
@Table(name = "car", schema = "public")
public class Car {
    @Id
    private int pk;

    private String make;
    private String model;
    private int seats;


}
