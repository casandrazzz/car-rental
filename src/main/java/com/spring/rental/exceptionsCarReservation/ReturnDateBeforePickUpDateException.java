package com.spring.rental.exceptionsCarReservation;

import lombok.Getter;

public class ReturnDateBeforePickUpDateException extends Exception {

    /**
     * error for the case when return date is before pick up date
     */
    @Getter
    private final int code;

    public ReturnDateBeforePickUpDateException(String message, int code) {

        super(message);
        this.code = code;
    }

}
