package com.spring.rental.exceptionsCarReservation;

import lombok.Getter;

public class ReturnDateBeforePickUpDateException extends Exception {
    @Getter
    private final int code;

    public ReturnDateBeforePickUpDateException(String message, int code) {

        super(message);
        this.code = code;
    }

}
