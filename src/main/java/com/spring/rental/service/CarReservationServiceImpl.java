package com.spring.rental.service;

import com.spring.rental.dao.CarRepository;
import com.spring.rental.dao.ReservationRepository;
import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.exceptions.InvalidCarReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class CarReservationServiceImpl implements CarReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CarRepository carRepository;


    public CarReservationServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public void addCar(CarReservationDto carReservationDto) throws InvalidCarReservation {
        Car car = new Car();
        car.setVehicleMake(carReservationDto.getVehicleMake());





        carRepository.save(car);
    }

    @Override
    public void deleteCar(long pk) {

    }

    @Override
    public void updateCar(long pk) {

    }

    @Override
    public Set<CarReservationDto> getAvailableCars(LocalDate pickUpDate, LocalDate returnDate) {


        Set<CarReservationDto> availableCars = new HashSet<>();


        Set <Car> cars = reservationRepository.getAvailableCars(pickUpDate, returnDate);
        for (Car car : cars){
                CarReservationDto carReservationDto = new CarReservationDto();
                carReservationDto.setTransmission(car.getTransmission());
                carReservationDto.setVehicleMake(car.getVehicleMake());
                carReservationDto.setVehicleModel(car.getVehicleModel());
                carReservationDto.setVehicleType(car.getVehicleType());
                carReservationDto.setSeats(car.getSeats());


                availableCars.add(carReservationDto);

            }
            return availableCars;
    }

    @Override
    public Set<CarReservationDto> getRentedCars() {
        return null;
    }

   // public SearchResults<Car> search(AvailableCarSearchCriteria searchCriteria) {
   //     AvailableCarSearchCriteria.CarSearchType searchType = searchCriteria.getSearchType();
   //     String sortOrder = searchCriteria.getSortOrder();
    //    System.out.println(searchType + ":" + sortOrder);
    //    List<Car> results = null;
     //   if (searchType == AvailableCarSearchCriteria.CarSearchType.BY_VEHICLE_TYPE) {
            //Use hibernate Criteria API to get and sort results based on USERNAME field in sortOrder
            //  results = userDAO.searchUsers(...);
      //  } else if (searchType == AvailableCarSearchCriteria.CarSearchType.BY_VEHICLE_MAKE) {
            //Use hibernate Criteria API to get and sort results based on USER_ID field in sortOrder
            //  results = userDAO.searchUsers(...);
      //  }

        //   CarSearchResults<Car> searchResults = new CarSearchResults<Car>();
        //   searchResults.setPageSize(searchCriteria.getPageSize());
        //   searchResults.setResults(results);
        //   return searchResults;
        // }

   }





