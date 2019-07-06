package com.spring.rental.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data

@Entity
@Table(name = "user", schema = "public")
public class User extends Person {
    @Id
    private int pk;

    private String username;
    private String password;

    private List<Car> userSelection = new ArrayList<>();


}
