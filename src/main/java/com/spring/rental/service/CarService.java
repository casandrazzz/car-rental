package com.spring.rental.service;

import com.spring.rental.dao.CarRepository;
import com.spring.rental.domain.Car;

import java.util.Collection;

public class CarService {

    CarRepository carRepository;

    public Collection<Car> getAll(){
        return carRepository.getAll();
    }

    public Car findById(Long id){
        return carRepository.findById(id);
    }

    Car update(Car car){
        return carRepository.update(car);
    }

    boolean delete(Car car){
        return carRepository.delete(car);
    }
}
