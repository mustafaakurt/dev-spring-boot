package com.mustafaakurt.restdemo.rest;

import com.mustafaakurt.restdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Mustafa", "Kurt"));
        studentList.add(new Student("Mario", "Rossi"));
        studentList.add(new Student("Marry", "Smith"));

        return studentList;
    }

}
