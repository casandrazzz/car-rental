package com.spring.rental.service;

import com.spring.rental.dao.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

import com.spring.rental.dto.EmployeeDto;
import com.spring.rental.dto.EmployeeInsertDto;
import com.spring.rental.domain.Employee;
import com.spring.rental.exceptions.employeeexceptions.*;
import com.spring.rental.validation.emplservicevalidation.EmployeeValidation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.spring.rental.exceptions.employeeexceptions.Codes.NO_EMPLOYEE;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Logger Log = Logger.getLogger(EmployeeServiceImpl.class);

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(EmployeeInsertDto employeeInsertDto) throws InvalidEmployeeFirstAndLastName, InvalidEmployeePhoneNumber, InvalidEmployeePassword, InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress {

        EmployeeValidation.firstNameValidation(employeeInsertDto);
        EmployeeValidation.lastNameValidation(employeeInsertDto);
        EmployeeValidation.phoneNumberOfEmployeeValidation(employeeInsertDto);
        EmployeeValidation.employeePasswordValidation(employeeInsertDto);
        EmployeeValidation.usernameValidation(employeeInsertDto);
        EmployeeValidation.employeeAgeValidation(employeeInsertDto);
        EmployeeValidation.employeeEmailAddressValidation(employeeInsertDto);

        Employee employee = new Employee();
        employee.setFirstName(employeeInsertDto.getFirstName());
        employee.setLastName(employeeInsertDto.getLastName());
        employee.setAge(employeeInsertDto.getAge());
        employee.setPhoneNumber(employeeInsertDto.getPhoneNumber());
        employee.setEmailAddress(employeeInsertDto.getEmailAddress());
        employee.setUsername(employeeInsertDto.getUsername());
        employee.setPassword(employeeInsertDto.getPassword());

        //Employee employee = employeeRepository.findById(employeeInsertDto.getId()).get();

        //maybe a transformer

        return employeeRepository.save(employee);


    }

    public Employee findById(long id) {

        return employeeRepository.findById(id).get();


    }

    public Employee updateEmployee(Employee employee) throws InvalidEmployeeFirstAndLastName, InvalidEmployeePhoneNumber, InvalidEmployeePassword, InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress {

       EmployeeValidation.firstNameValidation(employee);
        EmployeeValidation.lastNameValidation(employee);
        EmployeeValidation.phoneNumberOfEmployeeValidation(employee);
        EmployeeValidation.employeePasswordValidation(employee);
        EmployeeValidation.usernameValidation(employee);
        EmployeeValidation.employeeAgeValidation(employee);
        EmployeeValidation.employeeEmailAddressValidation(employee);

       return employeeRepository.save(employee);


    }




    @Override
    public List<EmployeeDto> getEmployees() throws NoEmployeeFound {


       List<EmployeeDto> availableEmployees = new ArrayList<>();

        List<Employee> employees = employeeRepository.getEmployees();
        for (Employee employee : employees) {
            EmployeeDto employeeDto = new EmployeeDto();

            employeeDto.setId(employee.getPk());
            employeeDto.setFirstName(employee.getFirstName());
            employeeDto.setLastName(employee.getLastName());
            employeeDto.setAge(employee.getAge());
            employeeDto.setPhoneNumber(employee.getPhoneNumber());
            employeeDto.setEmailAddress(employeeDto.getEmailAddress());

            availableEmployees.add(employeeDto);
            if (availableEmployees.isEmpty()) {
                throw new NoEmployeeFound("We didn't find you any employee at this moment", NO_EMPLOYEE);
            }


        }

        return availableEmployees;
        // This one is converted


    }

    @Override
    public List<Employee> getAllEmployees() throws NoEmployeeFound {


        return employeeRepository.getEmployees();


    }

    @Override
    public Employee getEmployee(long id) throws NoEmployeeFound {

       return employeeRepository.getEmployees().stream()
               .filter(employee -> employee.getPk() == id)
               .findFirst()
               .get();

       /*Employee employee = employeeRepository.getOne(id);

       return employeeRepository.getOne(id);*/





    }


    @Override
    public void deleteEmployee(long id)  {
      employeeRepository.deleteById(id);
    }


}
