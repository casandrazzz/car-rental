package com.spring.rental.exceptionsCarReservation;

import lombok.Getter;

public class InvalidCarReservation extends Exception {

    /**
     * Error for invalid car reservation
     */


    @Getter
    private final int code;

    public InvalidCarReservation(String message, int code) {

        super(message);
        this.code = code;
    }

}
