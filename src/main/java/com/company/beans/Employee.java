package com.company.beans;

//import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private String designation;
    private String email;
    private String Location;
    private Date joiningDate;

    public Employee(int id, String lastName, String firstName, int age, String designation, String email, String location, Date joiningDate) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.designation = designation;
        this.email = email;
        Location = location;
        this.joiningDate = joiningDate;
    }

    public Employee() {
    }

}
