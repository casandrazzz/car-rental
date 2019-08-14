package com.spring.rental.transformer.employeetransformer;

import com.spring.rental.domain.Employee;
import com.spring.rental.dto.EmployeeDto;

public class EmployeeEntityToEmployeeDtoTransformer {

    public  static EmployeeDto transform(Employee employee){

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setAge(employee.getAge());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        employeeDto.setEmailAddress(employee.getEmailAddress());

        return employeeDto;


    }








}
