package com.spring.rental.dao;

import com.spring.rental.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
List<Car> findByVehicleType (String VehicleType);
List<Car> findAll();
}
