package com.spring.rental.exceptionsCarReservation;

import lombok.Getter;

public class ReturnDateTooFarInTheFutureException extends Exception {

    /**
     * error for the case when return date is too far in the future
     */
    @Getter
    private final int code;

    public ReturnDateTooFarInTheFutureException(String message, int code) {

        super(message);
        this.code = code;
    }

}
