package com.spring.rental.exceptions.employeeexceptions;

import lombok.Getter;

public class InvalidEmployeePassword extends  Exception {

    @Getter
    private final int code;

    public InvalidEmployeePassword(String message, int code){
        super(message);
        this.code = code;

    }


}
