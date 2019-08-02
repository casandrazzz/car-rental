package com.spring.rental.exceptions;

import lombok.Getter;

public class CarNotFoundException extends Exception{
    @Getter
    private final int code;

    public CarNotFoundException(String message, int code) {

        super(message);
        this.code = code;
    }
}
