package com.spring.rental.controller;

import com.spring.rental.dao.*;
import com.spring.rental.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/db")
public class BulkController {


    @Autowired
    CarRepository carRepository;

    @PostMapping("/bulkcreateCar")
    public String bulkCreateCars(@RequestBody List<Car> car){
        // save a list of cars

        carRepository.saveAll(car);
        return "Cars are created";
    }

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/bulkcreateCustomer")
    public String bulkCreateCustomers(@RequestBody List<Customer> customer){
        // save a list of cars

        customerRepository.saveAll(customer);
        return "Customers are created";
    }

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/bulkcreateEmployee")
    public String bulkCreateEmployees(@RequestBody List<Employee> employee){
        // save a list of employees

        employeeRepository.saveAll(employee);
        return "Employees are created";
    }

    @Autowired
    ReservationRepository reservationRepository;

    @PostMapping("/bulkcreateReservation")
    public String bulkCreateReservation(@RequestBody List<Reservation> reservation){
        // save a list of employees

        reservationRepository.saveAll(reservation);
        return "Reservations are created";
    }


//    @PostMapping("/create")
//    public String create(@RequestBody AppUser appUser){
//        appUserRepository.save(appUser);
//        return "Application user " + appUser.getLastName() + appUser.getFirstName() + " is created";
//    }
//
//    @GetMapping("/findall")
//    public List<AppUser> findAll(){
//        List<AppUser> users = appUserRepository.findAll();
//
//        for (AppUser appUser: users) {
//            users.add(new AppUser(appUser.getFirstName(), appUser.getLastName(), appUser.getAge(), appUser.getPhoneNumber(), appUser.getEmailAddress(), appUser.getRole()));
//        }
//        return users;
//    }

}

