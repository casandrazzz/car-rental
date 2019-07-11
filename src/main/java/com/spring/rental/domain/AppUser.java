package com.spring.rental.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users", schema = "public")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pk;

    @Column (name = "firstName" )
    private String firstName;

    @Column (name = "lastName" )
    private String lastName;

    @Column (name = "age")
    private int age;

    @Column (name = "phoneNumber")
    private String phoneNumber;

    @Column (name = "emailAddress")
    private String emailAddress;

    @Column (name = "role")
    private String role;

    public AppUser (String firstName, String lastName, int age, String phoneNumber, String emailAddress, String role){
             this.setFirstName(firstName);
             this.setLastName(lastName);
             this.setAge(age);
             this.setPhoneNumber(phoneNumber);
             this.setEmailAddress(emailAddress);
             this.setRole(role);
    }

}
