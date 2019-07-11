package com.spring.rental.service;

import com.spring.rental.dao.EmployeeRepository;
import com.spring.rental.domain.Employee;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    Collection<Employee> getAll(){
        return employeeRepository.getAll();
    }

    Employee findById(Long id){
        return employeeRepository.findById(id);
    }

    Employee update(Employee employee){
        return employeeRepository.update(employee);
    }

    boolean delete(Employee employee){
        return employeeRepository.delete(employee);
    }
}
