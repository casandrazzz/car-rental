package com.spring.rental.dao;

import com.spring.rental.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface CarRepository extends JpaRepository<Car, Long> {


}