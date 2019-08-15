package com.spring.rental.exceptions.reservationExceptions;

import lombok.Getter;

public class PickUpDateInThePastException extends Exception{
    @Getter
    private final int code;

    public PickUpDateInThePastException(String message, int code) {

        super(message);
        this.code = code;
    }

}
