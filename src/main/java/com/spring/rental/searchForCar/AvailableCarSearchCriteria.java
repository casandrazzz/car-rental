package com.spring.rental.searchForCar;

import com.spring.rental.enums.VehicleType;

public class AvailableCarSearchCriteria extends SearchCriteria {

    public enum CarSearchType

    {
        BY_VEHICLE_TYPE,
        BY_VEHICLE_MAKE,
        BY_TRANSMISSION,
        BY_NUMBER_OF_SEATS;
    }

    private CarSearchType searchType = CarSearchType.BY_VEHICLE_TYPE;
    private int id;
    private String vehicleType;

    public CarSearchType getSearchType()
    {
        return searchType;
    }
    public void setSearchType(CarSearchType searchType)
    {
        this.searchType = searchType;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getVehicleType()
    {
        return vehicleType;
    }
    public void setVehicleType(String vehicleType)
    {
        this.vehicleType = vehicleType;
    }
}



