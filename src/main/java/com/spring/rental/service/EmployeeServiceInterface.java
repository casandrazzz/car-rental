package com.spring.rental.service;

import com.spring.rental.domain.Employee;
import com.spring.rental.dto.EmployeeDto;
import com.spring.rental.dto.EmployeeInsertDto;
import com.spring.rental.exceptions.employeeexceptions.*;

import java.util.List;

public interface EmployeeServiceInterface {
    /**
     *
     * @param firstName employee's first name
     * @param lastName employee's last name
     * @param age        employee's age
     * @param phoneNumber   employee's phone number
     * @param emailAddress    employee's email address
     * @param username           employee's username ( should be seen in admin mode)
     * @param password            employee's password ( should be available only for admin)
     */
    void addEmployee(String firstName, String lastName, int age,String phoneNumber,String emailAddress,String username,String password);

    void addEmployee(EmployeeInsertDto employeeInsertDto) throws InvalidEmployeeFirstAndLastName, InvalidEmployeePhoneNumber, InvalidEmployeePassword, InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress;

    void deleteEmployee(Integer id);




    boolean deleteEmployee(String username) throws InvalidEmployeeUsername;



    List<EmployeeDto> getEmployees();


    EmployeeDto findEmployeeByFirstName(String firstName) ;

    EmployeeDto findEmployeeByLastName(String lastName);

    EmployeeInsertDto findEmployeeByUsername(String username);

    EmployeeDto findEmployeeByEmailAddress(String emailAddress);

    EmployeeInsertDto updateEmployeeFirstName(String firstName);

    EmployeeInsertDto updateEmployeeLastName(String lastName);

    EmployeeInsertDto updateEmployeeUsername(String userName);

    EmployeeInsertDto updateEmployeeAge(Integer age);

    EmployeeInsertDto updateEmployeePassword(String password);

    EmployeeInsertDto updateEmployeeEmailAddress(String emailAddress);

    EmployeeInsertDto updateEmployeePhoneNumber(String phoneNumber);

}
