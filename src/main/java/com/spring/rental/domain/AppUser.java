package com.spring.rental.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data

@Entity
@Table(name = "user", schema = "public")
public class User extends AbstractModel{

    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String emailAddress;
    private String role;

}
