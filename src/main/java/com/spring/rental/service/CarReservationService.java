package com.spring.rental.service;


import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.exceptionsCarReservation.NoAvailableCarFound;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.Set;

public interface CarReservationService {
       /**
        * interface for CarReservationService implementation
        * @param pickUpDate
        * @param returnDate
        * @return
        * @throws NoAvailableCarFound
        */

       Set<CarReservationDto> getAvailableCars(LocalDate pickUpDate, LocalDate returnDate) throws NoAvailableCarFound;
       Set<CarReservationDto> getAvailableCarReservationDto(@Param("pickUpDate") LocalDate pickUpDate, @Param("returnDate") LocalDate returnDate);
}
