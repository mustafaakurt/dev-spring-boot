package com.mustafaakurt.restdemo.rest;

import com.mustafaakurt.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> studentList;

    // define @PostConstruct to load the data ... only once!
    @PostConstruct
    public void loadData(){

        studentList = new ArrayList<>();

        studentList.add(new Student("Mustafa", "Kurt"));
        studentList.add(new Student("Mario", "Rossi"));
        studentList.add(new Student("Marry", "Smith"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return studentList.get(studentId);
    }


}
