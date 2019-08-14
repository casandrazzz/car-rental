package com.spring.rental.transformer.employeetransformer;

import com.spring.rental.domain.Employee;
import com.spring.rental.dto.EmployeeInsertDto;

public class EmployeeEntityToEmployeeDtoInsertTransformer {

    public  static EmployeeInsertDto transform(Employee employee) {

        EmployeeInsertDto employeeInsertDto = new EmployeeInsertDto();
        employeeInsertDto.setFirstName(employee.getFirstName());
        employeeInsertDto.setLastName(employee.getLastName());
        employeeInsertDto.setAge(employee.getAge());
        employeeInsertDto.setPhoneNumber(employee.getPhoneNumber());
        employeeInsertDto.setEmailAddress(employee.getEmailAddress());
        employeeInsertDto.setUsername(employee.getUsername());
        employeeInsertDto.setPassword(employee.getPassword());

        return employeeInsertDto;
    }


}
