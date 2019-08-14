package com.spring.rental.dto;

import lombok.*;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private  String firstName;
    private String lastName;
    private  int age;
    private  String phoneNumber;
    private  String emailAddress;


}
