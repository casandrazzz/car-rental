package com.spring.rental.service;

import com.spring.rental.dto.EmployeeDto;
import com.spring.rental.dto.EmployeeInsertDto;
import com.spring.rental.exceptions.employeeexceptions.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeServiceInterface {
   /* *//**
     *
     * @param firstName employee's first name
     * @param lastName employee's last name
     * @param age        employee's age
     * @param phoneNumber   employee's phone number
     * @param emailAddress    employee's email address
     * @param username           employee's username ( should be seen in admin mode)
     * @param password            employee's password ( should be available only for admin)
     *//*
    void addEmployee(String firstName, String lastName, int age,String phoneNumber,String emailAddress,String username,String password);
*/
    void addEmployee(EmployeeInsertDto employeeInsertDto) throws InvalidEmployeeFirstAndLastName, InvalidEmployeePhoneNumber, InvalidEmployeePassword, InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress;

/*
    List<EmployeeDto> deleteEmployee(long pk);
*/




/*
    boolean deleteEmployee(String username) throws InvalidEmployeeUsername;
*/



    List<EmployeeDto> getEmployees(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("age") int age,@Param("phoneNumber") String phoneNumber, @Param("emailAddress") String emailAddress) throws NoEmployeeFound;
    List<EmployeeDto> delete(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("age") int age,@Param("phoneNumber") String phoneNumber, @Param("emailAddress") String emailAddress, @Param("pk") long pk) throws NoEmployeeFound;

/*
    EmployeeFindResults<EmployeeInsertDto> search(
                                                  String firstName,
                                                  String lastName,
                                                  String username,
                                                  String emailAddress
    );*/





/*

    EmployeeInsertDto updateEmployeeFirstName(String firstName);

    EmployeeInsertDto updateEmployeeLastName(String lastName);

    EmployeeInsertDto updateEmployeeUsername(String userName);

    EmployeeInsertDto updateEmployeeAge(Integer age);

    EmployeeInsertDto updateEmployeePassword(String password);

    EmployeeInsertDto updateEmployeeEmailAddress(String emailAddress);

    EmployeeInsertDto updateEmployeePhoneNumber(String phoneNumber);
*/

}
