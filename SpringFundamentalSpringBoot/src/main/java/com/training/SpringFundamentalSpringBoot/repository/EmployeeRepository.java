package com.training.SpringFundamentalSpringBoot.repository;

import com.training.SpringFundamentalSpringBoot.domain.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> findAll() {
        Query query = entityManager.createQuery("from Employee");
        return query.getResultList();
    }

    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    public Employee findByLastName(String  lastName) {
        Query query = entityManager.createQuery("from Employee e where e.lastName = :LAST_NAME");
        query.setParameter("LAST_NAME", lastName);
        List resultList = query.getResultList();

        return resultList.isEmpty()? null : (Employee) resultList.get(0);
    }

    public List<Employee> findAllByNativeQuery() {
        Query nativeQuery = entityManager.createNativeQuery("select id, first_name, last_name from employee", Employee.class);
        return nativeQuery.getResultList();
    }

    @Transactional
    public Employee save(Employee employee) {
        this.entityManager.persist(employee);
        return employee;
    }

    @Transactional
    public void delete(Integer id) {

        Employee employee = this.findById(id);
        this.entityManager.remove(employee);

    }

}
