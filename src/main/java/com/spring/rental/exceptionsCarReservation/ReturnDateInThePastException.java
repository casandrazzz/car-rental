package com.spring.rental.exceptionsCarReservation;

import lombok.Getter;

public class ReturnDateInThePastException extends Exception {

    /**
     * error for the case when return date is before current date
     */

    @Getter
    private final int code;

    public ReturnDateInThePastException(String message, int code) {

        super(message);
        this.code = code;
    }

}
