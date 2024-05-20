package com.mustafaakurt.cruddemo.dao;

import com.mustafaakurt.cruddemo.entity.Student;

public interface StudentDAO {
    void saveStudent(Student student);

    Student findById(Integer id);
}
