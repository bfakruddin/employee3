package com.company.controller;

import com.company.beans.Employee;
import com.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Tag(name="EmployeeController")
@RestController
@RequestMapping("/company")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public String swaggerUi() {
        return "redirect:/swagger-ui.html";
    }

    @GetMapping(path = "/echo")
    public String getEcho() {
        return "Echo 1.. 2.. 3..";
    }

    @GetMapping(path = "/hello/{name}")
    public String helloApp(@PathVariable String name) {
        return "Hello " + name;
    }

    @RequestMapping(method = RequestMethod.GET, value="/employees")
    public List<Employee> getAllEmployees(){
        System.out.println("************************    hello    ***************************");
        return employeeService.getAllEmployees();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getallemployees")
    public void getEmployees(){
        employeeService.getAllEmployees();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addemployee")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateemployee/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        employeeService.updateEmployee(id, employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/deleteemployee/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getemployeebyfirstname/{firstName}")
    public Employee getEmployeeById(@PathVariable String firstName){
        return employeeService.getEmployeeBy(firstName);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getemployeebyid/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        return new ResponseEntity<>(employeeService.getEmployeeBy(id), HttpStatus.OK);
//        return employeeService.getEmployeeBy(id);
    }
}
