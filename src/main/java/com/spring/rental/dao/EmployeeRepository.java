package com.spring.rental.dao;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.spring.rental.domain.Employee;

import com.spring.rental.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
List<Employee> findByFirstName(String FirstName);
List<Employee> findAll();
F}
