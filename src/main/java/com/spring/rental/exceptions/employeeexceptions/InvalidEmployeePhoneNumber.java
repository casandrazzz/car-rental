package com.spring.rental.exceptions.employeeexceptions;

import lombok.Getter;

public class InvalidEmployeePhoneNumber extends   Exception {

    @Getter
    private  final  int code;

    public  InvalidEmployeePhoneNumber(String message, int code){
        super(message);
        this.code = code;
    }



}
