package com.company.repository;

import com.company.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("From Employee where id=?1")
    Employee findEmployeeById(int id);

    @Query("From Employee where firstName=?1")
    Employee findEmployeeByFirstName(String firstName);
}
