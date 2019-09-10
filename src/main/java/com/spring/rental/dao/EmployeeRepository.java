package com.spring.rental.dao;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.spring.rental.domain.Employee;

import com.spring.rental.domain.Employee;
import com.spring.rental.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value ="SELECT * FROM Employee", nativeQuery = true)
    List <Employee> getEmployees();


    @Query(value = "SELECT * FROM Employee e WHERE e.firstName =:firstName", nativeQuery = true)
    List<Employee> findEmployeesByFirstName(@Param("firstName") String firstName);



    @Query(value = "SELECT * FROM Employee e WHERE e.lastName =:lastName", nativeQuery = true)
    List<Employee> findEmployeesByLastName(@Param("lastName") String lastName);




    @Query(value = "SELECT * FROM Employee e WHERE e.username =:username", nativeQuery = true)
    List<Employee> findEmployeesByUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM Employee e WHERE e.emailAddress =:emailAddress", nativeQuery = true)
    List<Employee> findEmployeesByEmailAddress(@Param("emailAddress") String emailAddress);


    @Query(value = "delete from Employee e where e.pk=:pk")
    Employee deleteEmployee(@Param("pk") long pk);

}
