package com.spring.rental.dao;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.spring.rental.domain.Employee;

import com.spring.rental.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByFirstName(String firstName);




    Employee findByLastName(String LastName);




    Employee findByUsername(String username);



    Employee findByEmailAdress(String emailAddress);


}
