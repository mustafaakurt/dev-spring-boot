package com.mustafaakurt.restcrud.dao;

import com.mustafaakurt.restcrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entityManager
    EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // execute qeury and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    // when you use entitiyManager.merge if id == 0 then save else update

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
