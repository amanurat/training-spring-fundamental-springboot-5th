package com.training.SpringFundamentalSpringBoot.repository;

import com.training.SpringFundamentalSpringBoot.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeCrudRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

}