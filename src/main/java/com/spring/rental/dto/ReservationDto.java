package com.spring.rental.dto;

import com.spring.rental.domain.Car;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Data
@ToString
public class ReservationDto {

    private String location;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private Set<Car> availableCars;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Set<Car> getAvailableCars() {
        return availableCars;
    }

    public void setAvailableCars(Set<Car> availableCars) {
        this.availableCars = availableCars;
    }
}
