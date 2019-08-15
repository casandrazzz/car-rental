package com.spring.rental.exceptions.reservationExceptions;

import lombok.Getter;

public class ReturnDateInThePastException extends Exception {

    @Getter
    private final int code;

    public ReturnDateInThePastException(String message, int code) {

        super(message);
        this.code = code;
    }

}
