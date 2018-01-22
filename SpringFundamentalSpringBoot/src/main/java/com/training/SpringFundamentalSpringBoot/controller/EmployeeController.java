package com.training.SpringFundamentalSpringBoot.controller;


import com.training.SpringFundamentalSpringBoot.domain.Employee;
import com.training.SpringFundamentalSpringBoot.exception.ResourceNotFoundException;
import com.training.SpringFundamentalSpringBoot.repository.EmployeeCrudRepository;
import com.training.SpringFundamentalSpringBoot.repository.EmployeeRepository;
import com.training.SpringFundamentalSpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @GetMapping
    public List<Employee> getEmployees(){
        System.out.println("Get All Employee");

        List<Employee> employeeList = this.employeeRepository.findAll();
//        List<Employee> employeeList = this.employeeService.findAllEmployee();

        return employeeList;
    }

    @GetMapping("/crud")
    public List<Employee> getEmployeesCrud(){
        return this.employeeCrudRepository.findAll();
    }

    @GetMapping("/crud/{id}")
    public Employee getEmployeesCrudById(@PathVariable Integer id){
        Employee employee = this.employeeCrudRepository.findOne(id);
        if (employee == null) {
            throw new ResourceNotFoundException("Employee number " + id + " not found");
        }
        return  employee;
    }
    @GetMapping("/crud/lastName/{value}")
    public List<Employee> getEmployeesCrudByLastName(@PathVariable String value){
        return this.employeeCrudRepository.findByLastName(value);
    }


    @GetMapping("/native")
    public List<Employee> getEmployeesByNative(){
        System.out.println("Get All Employee");

        List<Employee> employeeList = this.employeeRepository.findAllByNativeQuery();

        return employeeList;
    }

    @RequestMapping("{id}")
    public Employee getEmployee(@PathVariable Integer id) {

        Employee employee = this.employeeService.getEmployee(id);
        if (employee == null) {
            throw new ResourceNotFoundException("Employee number " + id + " not found");
        }

        return employee;
    }

    @GetMapping("/lastName/{value}")
    public Employee getEmployeeByLastName(@PathVariable String value) {

        Employee employee = this.employeeRepository.findByLastName(value);
        if (employee == null) throw new ResourceNotFoundException("not found");
        return employee;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        Employee employeeResponse = this.employeeService.saveEmployee(employee);

//        return new ResponseEntity<>(employee, HttpStatus.CREATED);
        return employeeResponse;
    }

    @PutMapping("{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeParam) {

        Employee employee = this.employeeService.getEmployee(id);

        employee.setFirstName(employeeParam.getFirstName());
        employee.setLastName(employeeParam.getLastName());

        Employee employeeUpdated = this.employeeService.saveEmployee(employee);
        return  employeeUpdated;
    }


    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        this.employeeService.deleteEmployee(id);
    }

    @GetMapping("/paramEmployee")
    public Employee paramEmployee(Employee employee) {

        return employee;
    }

    @PostMapping("/postEmployee")
    public Employee postEmployee(@RequestBody Employee employee) {

        return employee;
    }

    @GetMapping("/param")
    public String param(@RequestParam(required = false) String first,
                        @RequestParam(required = false) String second) {
        return "Get specific parameter first with : " + first + " and second : "+ second;
    }





}
