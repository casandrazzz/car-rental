package com.spring.rental.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@Builder
@ToString
@Table(name = "employee")
public class Employee {




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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
