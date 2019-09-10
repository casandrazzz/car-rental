package com.spring.rental.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Employee {
    /**
     * Employee table; employee performs car management action (CRUD)
     */

    public Employee(){

    }


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

    @Column (name = "email_address")
    private String emailAddress;

    @Column (name = "username")
    private String username;

    @Column (name = "password")
    private String password;



}
