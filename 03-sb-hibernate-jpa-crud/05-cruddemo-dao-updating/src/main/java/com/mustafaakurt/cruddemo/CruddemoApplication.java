package com.mustafaakurt.cruddemo;

import com.mustafaakurt.cruddemo.dao.StudentDAO;
import com.mustafaakurt.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            // createStudent(studentDAO);

            // createMultipleStudents(studentDAO);

            // readStudent(studentDAO);

            // queryForStudents(studentDAO);

            // queryForStudentsByLastName(studentDAO);

            // updateStudent(studentDAO);

            // deleteStudent(studentDAO);

            deleteAllStudent(studentDAO);
        };
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numRowDeleted = studentDAO.deleteAll();

        System.out.println("Deleted row count: " + numRowDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 4;
        System.out.println("Deleting student with id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {

        // retrieve student based on the id : primary key
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // change first name to "Scooby"
        System.out.println("Updating student ...");
        myStudent.setFirstName("Mustafa");

        // update the student
        studentDAO.update(myStudent);

        //display the updated student
        System.out.println("Updated student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Duck");

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        Student student = new Student("Duffy", "Duck", "duffy@gmail.com");

        // save the student
        studentDAO.saveStudent(student);

        // display id of the saved student
        int theId = student.getId();
        System.out.println("Saved student with id : " + theId);

        // retrieve student based on the id : primary key
        System.out.println("Retrieving student with id : " + theId);
        Student myStudent = studentDAO.findById(theId);

        // display student
        System.out.println("Found the student : " + myStudent);

    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        // create multiple students
        System.out.println("Creating 3 new student object ...");
        Student student1 = new Student("John", "Doe", "john@gmail.com");
        Student student2 = new Student("Marry", "Public", "mary@gmail.com");
        Student student3 = new Student("Bonita", "Applebum", "bonita@gmail.com");

        // save the student objects
        System.out.println("Saving the students ...");
        studentDAO.saveStudent(student1);
        studentDAO.saveStudent(student2);
        studentDAO.saveStudent(student3);


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
