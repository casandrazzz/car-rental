package com.spring.rental.controller;

import com.spring.rental.domain.Employee;
import com.spring.rental.dto.EmployeeDto;
import com.spring.rental.dto.EmployeeInsertDto;
import com.spring.rental.exceptions.employeeexceptions.*;
import com.spring.rental.service.EmployeeServiceInterface;
import com.spring.rental.service.EmployeeServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:63342")
public class EmployeeController {

    private static final Logger Log = Logger.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeServiceInterface employeeServiceInterface;





    @PostMapping(value = "/employees")
    public Employee addEmployee(@ModelAttribute EmployeeInsertDto employeeInsertDto) throws InvalidEmployeeUsername, InvalidEmployeeAge,
            InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {

        try{
            return employeeServiceInterface.addEmployee(employeeInsertDto);

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

        return employeeServiceInterface.addEmployee(employeeInsertDto);

        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");*/
        // good
    }

    @PostMapping(value = "/employees/{id}")
    public Employee updateEmployee(@ModelAttribute EmployeeInsertDto employeeInsertDto, @PathVariable long id) {

        Employee employee = employeeServiceInterface.findById(id);

        employee.setFirstName(employeeInsertDto.getFirstName());
        employee.setLastName(employeeInsertDto.getLastName());
        employee.setAge(employeeInsertDto.getAge());
        employee.setPhoneNumber(employeeInsertDto.getPhoneNumber());
        employee.setEmailAddress(employeeInsertDto.getEmailAddress());

        return employeeServiceInterface.updateEmployee(employee);

        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");*/
        // good
    }
    @DeleteMapping(value = "/delete/{id}")
    public  void deleteEmployee( @PathVariable long id) throws NoEmployeeFound {
         employeeServiceInterface.deleteEmployee(id);


    }


    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(method = RequestMethod.GET, value = "/employees")
    public List<EmployeeDto> getAllemployes() throws NoEmployeeFound {
        return employeeServiceInterface.getEmployees();
    }
    



}
