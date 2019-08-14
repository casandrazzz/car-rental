package com.spring.rental.exceptions.employeeexceptions;

import lombok.Getter;

public class InvalidEmployeeEmailAddress extends Exception {
    @Getter
    private final int code;

    public  InvalidEmployeeEmailAddress(String message, int code) {
        super(message);
        this.code = code;

    }
}
