package com.spring.rental.controller;

import com.spring.rental.domain.Employee;
import com.spring.rental.dto.EmployeeDto;
import com.spring.rental.dto.EmployeeInsertDto;
import com.spring.rental.exceptions.employeeexceptions.*;
import com.spring.rental.service.EmployeeServiceInterface;
import com.spring.rental.service.EmployeeServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {

    //private static final Logger Log = Logger.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeServiceInterface employeeServiceInterface;





    @PostMapping()
    public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeInsertDto employeeInsertDto) throws InvalidEmployeeUsername, InvalidEmployeeAge,
            InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {

        try{
            return new ResponseEntity<>(employeeServiceInterface.addEmployee(employeeInsertDto),HttpStatus.CREATED);

            //System.out.println(" EmployeeServiceInterface inserted with success");
        } catch (InvalidEmployeeUsername invalidEmployeeUsername) {
            System.out.println(invalidEmployeeUsername.getLocalizedMessage() + ":" + invalidEmployeeUsername.getCode());

        } catch (InvalidEmployeeEmailAddress invalidEmployeeEmailAddress) {
            System.out.println(invalidEmployeeEmailAddress.getLocalizedMessage() + ":" + invalidEmployeeEmailAddress.getCode());

        } catch (InvalidEmployeePhoneNumber invalidEmployeePhoneNumber) {
            System.out.println(invalidEmployeePhoneNumber.getLocalizedMessage() + ":" + invalidEmployeePhoneNumber.getCode());

        } catch (InvalidEmployeeAge invalidEmployeeAge) {
            System.out.println(invalidEmployeeAge.getLocalizedMessage() + ":" + invalidEmployeeAge.getCode() );

        } catch (InvalidEmployeePassword invalidEmployeePassword) {
            System.out.println(invalidEmployeePassword.getLocalizedMessage() + ":" + invalidEmployeePassword.getCode());

        } catch (InvalidEmployeeFirstAndLastName invalidEmployeeFirstAndLastName) {
            System.out.println(invalidEmployeeFirstAndLastName.getLocalizedMessage() + ":" + invalidEmployeeFirstAndLastName.getCode());
        }

        return new ResponseEntity<>(employeeServiceInterface.addEmployee(employeeInsertDto),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody EmployeeInsertDto employeeInsertDto, @PathVariable long id) {

        Employee employee = employeeServiceInterface.findById(id);

        employee.setFirstName(employeeInsertDto.getFirstName());
        employee.setLastName(employeeInsertDto.getLastName());
        employee.setAge(employeeInsertDto.getAge());
        employee.setPhoneNumber(employeeInsertDto.getPhoneNumber());
        employee.setEmailAddress(employeeInsertDto.getEmailAddress());

        return new ResponseEntity<>(employeeServiceInterface.updateEmployee(employee),HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteEmployee( @PathVariable long id) throws NoEmployeeFound {
        employeeServiceInterface.deleteEmployee(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = null;
        try {
            employees = employeeServiceInterface.getAllEmployees();
        } catch (NoEmployeeFound noEmployeeFound) {
            noEmployeeFound.printStackTrace();
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable long id) {
        EmployeeDto employeeDto = null;
        try {
            employeeDto = employeeServiceInterface.getEmployee(id);
        } catch (NoEmployeeFound noEmployeeFound) {
            noEmployeeFound.printStackTrace();
        }
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @GetMapping("/search/{term}")
    public ResponseEntity<List<Employee>> searchEmployee(@PathVariable String term) {
        List<Employee> employees = null;
        try {
            employees = employeeServiceInterface.getAllEmployees()
                    .stream()
                    .filter((employee) -> employee.getFirstName().contains(term) && employee.getLastName().contains(term))
                    .collect(Collectors.toList());
        } catch (NoEmployeeFound noEmployeeFound) {
            noEmployeeFound.printStackTrace();
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity options(HttpServletResponse response) {
        response.setHeader("Allow", "HEAD,GET,PUT,OPTIONS,POST,DELETE");
        return new ResponseEntity(HttpStatus.OK);
    }


}
