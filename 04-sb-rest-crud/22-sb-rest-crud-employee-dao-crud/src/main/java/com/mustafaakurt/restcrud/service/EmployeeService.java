package com.mustafaakurt.restcrud.service;

import com.mustafaakurt.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeService{

    List<Employee> findAll();
}
