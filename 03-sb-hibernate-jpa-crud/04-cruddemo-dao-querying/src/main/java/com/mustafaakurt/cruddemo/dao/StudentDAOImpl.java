package com.mustafaakurt.cruddemo.dao;

import com.mustafaakurt.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for the entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save methods
    @Override
    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    // implement findById method
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student ORDER BY lastName ASC", Student.class);

        //return query results
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theLastName", Student.class);

        // set query parameters
        theQuery.setParameter("theLastName", lastName);

        // return query results
        return theQuery.getResultList();
    }
}
