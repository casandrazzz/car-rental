package com.spring.rental.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data

@Entity
@Table(name = "customer", schema = "public")
public class Customer {

    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pk;

    @Column(name = "firstName" )
    private String firstName;

    @Column (name = "lastName" )
    private String lastName;

    @Column (name = "age")
    private int age;

    @Column (name = "phoneNumber")
    private String phoneNumber;

    @Column (name = "emailAddress")
    private String emailAddress;

    @Column (name = "username")
    private String username;

    @Column (name = "password")
    private String password;



}
