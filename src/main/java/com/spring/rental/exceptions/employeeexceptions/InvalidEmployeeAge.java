package com.spring.rental.exceptions.employeeexceptions;

import lombok.Getter;

public class InvalidEmployeeAge extends  Exception {

    @Getter
    private final int code;

    public  InvalidEmployeeAge(String message, int code){
        super(message);
        this.code = code;
    }

}
