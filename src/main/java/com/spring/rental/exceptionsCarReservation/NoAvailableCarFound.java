package com.spring.rental.exceptionsCarReservation;

import lombok.Getter;

public class NoAvailableCarFound extends Exception {

    @Getter
    private final int code;

    public NoAvailableCarFound(String message, int code) {

        super(message);
        this.code = code;
    }

}
