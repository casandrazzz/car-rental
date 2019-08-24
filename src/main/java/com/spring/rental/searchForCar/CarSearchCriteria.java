package com.spring.rental.searchForCar;


import lombok.Data;

@Data
public class CarSearchCriteria extends SearchCriteria {

    public enum CarSearchType{
        BY_TYPE,
        BY_MAKE,
        BY_TRANSMISSION,
        BY_SEATS
    }


    private CarSearchType searchType = CarSearchType.BY_TYPE;
    private String vehicleMake;
    private String vehicleType;
    private String transmission;
    private int seats;

  }



