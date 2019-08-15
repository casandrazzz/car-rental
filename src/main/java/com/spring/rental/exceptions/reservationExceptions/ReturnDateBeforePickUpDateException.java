package com.spring.rental.exceptions.reservationExceptions;

import lombok.Getter;

public class ReturnDateBeforePickUpDateException extends Exception {
    @Getter
    private final int code;

    public ReturnDateBeforePickUpDateException(String message, int code) {

        super(message);
        this.code = code;
    }

}
