package com.spring.rental.model;

import lombok.Data;

import javax.persistence.Entity;

@Data

@Entity
public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String emailAddress;

}
