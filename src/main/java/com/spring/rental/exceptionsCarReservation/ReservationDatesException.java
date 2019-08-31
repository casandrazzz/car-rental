package com.spring.rental.exceptionsCarReservation;

import java.util.Arrays;

public class ReservationDatesException extends Exception {

    /**
     * other validations for reservation dates
     */

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