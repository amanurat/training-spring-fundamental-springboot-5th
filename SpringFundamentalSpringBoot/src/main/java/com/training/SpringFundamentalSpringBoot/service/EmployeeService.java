package com.training.SpringFundamentalSpringBoot.service;

import com.training.SpringFundamentalSpringBoot.domain.Employee;
import com.training.SpringFundamentalSpringBoot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployee() {
        return this.employeeRepository.findAll();
    }

    public Employee getEmployee(Integer id) {
        return this.employeeRepository.findById(id);
    }

    @Transactional
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployee(Integer id) {
        this.employeeRepository.delete(id);
    }


}
