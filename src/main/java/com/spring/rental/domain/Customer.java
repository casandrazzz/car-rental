package com.spring.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Column (name = "driverLicenseNumber")
    private String driverLicenseNumber;



}
