package com.spring.rental.service;

import com.spring.rental.dao.CarRepository;
import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarDto;
import com.spring.rental.exceptionsCarReservation.InvalidCarReservation;
import com.spring.rental.exceptionsCarReservation.NoAvailableCarFound;
import com.spring.rental.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.spring.rental.exceptionsCarReservation.Codes.NO_AVAILABLE_CAR_FOUND;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public CarServiceImpl(final CarRepository carRepository,
                          final CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public List<CarDto> findAll() {
        return carRepository.findAll().stream().map(it ->  carMapper.toDto(it)).collect(Collectors.toList());
    }

    @Override
    public void addCar(CarDto carDto) throws InvalidCarReservation {
        Car car = new Car();
        car.setVehicleMake(carDto.getVehicleMake());
        carRepository.save(car);
    }

    @Override
    public void deleteCar(long pk) {

    }

    @Override
    public void updateCar(long pk) {

    }

    @Override
    public Set<CarDto> getAvailableCars(LocalDate pickUpDate, LocalDate returnDate) throws NoAvailableCarFound {

        Set<CarDto> availableCars = new HashSet<>();

        Set<Car> cars = carRepository.getAvailableCars(pickUpDate, returnDate);
        for (Car car : cars) {
            CarDto carDto = new CarDto();
            carDto.setTransmission(car.getTransmission());
            carDto.setVehicleMake(car.getVehicleMake());
            carDto.setVehicleModel(car.getVehicleModel());
            carDto.setVehicleType(car.getVehicleType());
            carDto.setSeats(car.getSeats());

            availableCars.add(carDto);
            if (availableCars.isEmpty()) {
                throw new NoAvailableCarFound("No available cars found. Please refine your search", NO_AVAILABLE_CAR_FOUND);
            }
        }
        return availableCars;
    }

    @Override
    public Set<CarDto> getRentedCars() {
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





