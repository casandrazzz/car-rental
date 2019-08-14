package com.spring.rental.exceptions.employeeexceptions;

import lombok.Getter;

public class InvalidEmployeeFirstAndLastName extends Exception
{
    @Getter
    private  final  int code;

    public InvalidEmployeeFirstAndLastName(String message, int code){
        super(message);
        this.code = code;
    }



}
