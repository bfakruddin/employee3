package com.company.service;

import com.company.beans.Employee;
import com.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    public void updateEmployee(int id, Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(String.valueOf(id));
    }

    public Employee getEmployeeBy(int id){
        return employeeRepository.findEmployeeById(id);
    }

    public Employee getEmployeeBy(String firstName){
        return employeeRepository.findEmployeeByFirstName(firstName);
    }
}
