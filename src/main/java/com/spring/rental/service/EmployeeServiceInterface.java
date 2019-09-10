package com.spring.rental.service;

import com.spring.rental.domain.Employee;
import com.spring.rental.dto.EmployeeDto;
import com.spring.rental.dto.EmployeeInsertDto;
import com.spring.rental.exceptions.employeeexceptions.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeServiceInterface {

    Employee addEmployee(EmployeeInsertDto employeeInsertDto) throws InvalidEmployeeFirstAndLastName, InvalidEmployeePhoneNumber, InvalidEmployeePassword, InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress;



    Employee findById(long id);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(long id) throws NoEmployeeFound;

    List<EmployeeDto> getEmployees() throws NoEmployeeFound;

/*
    EmployeeFindResults<EmployeeInsertDto> search(
                                                  String firstName,
                                                  String lastName,
                                                  String username,
                                                  String emailAddress
    );*/







}
