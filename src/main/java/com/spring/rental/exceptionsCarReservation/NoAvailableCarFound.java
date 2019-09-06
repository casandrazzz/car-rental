package com.spring.rental.exceptionsCarReservation;

import lombok.Getter;

public class NoAvailableCarFound extends Exception {
    /**
     * Error for the case when no available car is found in the selected interval of time
     */

    @Getter
    private final int code;

    public NoAvailableCarFound(String message, int code) {

        super(message);
        this.code = code;
    }

}
