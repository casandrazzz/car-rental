package com.spring.rental.exceptions.reservationExceptions;

import java.util.Arrays;

public class ReservationDatesException extends Exception {

    private String[] causes;

    public ReservationDatesException(String... causes) {
        super();
        this.causes = causes;
    }

    @Override
    public String getMessage() {

        return causes != null ? Arrays.toString(causes) : "No CAUSE!";
    }
    
}