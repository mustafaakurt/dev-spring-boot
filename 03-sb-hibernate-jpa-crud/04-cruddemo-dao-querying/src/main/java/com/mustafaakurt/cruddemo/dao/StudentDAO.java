package com.mustafaakurt.cruddemo.dao;

import com.mustafaakurt.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void saveStudent(Student student);

    Student findById(Integer id);

    List<Student> findAll();
    List<Student> findByLastName(String lastName);
}
