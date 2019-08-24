package com.spring.rental.searchForCar;

import org.springframework.stereotype.Service;

import java.text.MessageFormat;


public class CarSearchResults<CarReservationDto> extends SearchResults {

    public static String getDataGridMessage(int start, int end, int total)
    {
        return MessageFormat.format("Displaying {0} to {1} available Cars of {2}", start, end, total);
    }

}
