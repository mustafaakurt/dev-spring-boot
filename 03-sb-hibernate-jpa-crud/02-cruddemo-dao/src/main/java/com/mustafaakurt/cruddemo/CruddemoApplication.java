package com.mustafaakurt.cruddemo;

import com.mustafaakurt.cruddemo.dao.StudentDAO;
import com.mustafaakurt.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student objects
        System.out.println("Creating new student object ...");
        Student student = new Student("Mustafa", "Kurt", "mustafa@gmail.com");

        // save the student object
        System.out.println("Student is saving ...");
        studentDAO.saveStudent(student);

        // display id of the saved student
        System.out.println("Student saved with id : " + student.getId());
    }

}
