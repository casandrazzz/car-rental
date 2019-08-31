package com.spring.rental.dao;


import com.spring.rental.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    /**
     * method for finding a customer by id
     * @param pk
     * @return list of customers
     */

    Customer findById(@Param("pk") long pk);

}
