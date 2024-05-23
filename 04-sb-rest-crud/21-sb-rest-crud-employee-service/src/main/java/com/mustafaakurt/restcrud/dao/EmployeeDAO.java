package com.mustafaakurt.restcrud.dao;

import com.mustafaakurt.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
