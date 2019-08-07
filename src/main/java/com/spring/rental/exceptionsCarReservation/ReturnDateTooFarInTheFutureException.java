package com.spring.rental.exceptionsCarReservation;

import lombok.Getter;

public class ReturnDateTooFarInTheFutureException extends Exception {
    @Getter
    private final int code;

    public ReturnDateTooFarInTheFutureException(String message, int code) {

        super(message);
        this.code = code;
    }

}