package com.spring.rental.domain;

import javax.persistence.*;

@Entity
@Table(name = "employee", schema = "public")
public class Employee extends AbstractModel {
    private String firstName;
    private String lastName;
}
