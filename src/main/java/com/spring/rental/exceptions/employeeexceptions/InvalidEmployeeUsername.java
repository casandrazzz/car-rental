package com.spring.rental.exceptions.employeeexceptions;

import lombok.Getter;

public class InvalidEmployeeUsername extends  Exception {

    @Getter
    private final int code;

    public InvalidEmployeeUsername(String message, int code){
        super(message);
        this.code = code;
    }

}
