package com.spring.rental.dao;


import com.spring.rental.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
