package com.spring.rental.dao;

import com.spring.rental.domain.AppUser;
import com.spring.rental.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    List<AppUser> findByFirstName (String FirstName);
    List<AppUser> findAll();
}
