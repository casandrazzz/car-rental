package com.spring.rental.dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInsertDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private  String firstName;
    private String lastName;
    private  int age;
    private  String phoneNumber;
    private  String emailAddress;
    private  String username;
    private  String password;
}
