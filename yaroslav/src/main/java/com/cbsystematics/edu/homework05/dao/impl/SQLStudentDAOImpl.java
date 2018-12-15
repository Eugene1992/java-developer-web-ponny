package com.cbsystematics.edu.homework05.dao.impl;

import com.cbsystematics.edu.homework05.dao.StudentDAO;
import com.cbsystematics.edu.homework05.entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class SQLStudentDAOImpl implements StudentDAO {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM postgres.public.students";
    private static final String DELETE_QUERY = "DELETE FROM postgres.public.students WHERE id = ?1";
    private static final String SELECT_QUERY = "SELECT * FROM postgres.public.students WHERE id = ?1";
    private static final String UPDATE_QUERY = "UPDATE postgres.public.students SET first_name = ?1, last_name = ?2, age = ?3, average_mark = ?4";
    public static final String INSERT_QUERY = "INSERT INTO postgres.public.students(first_name, last_name, age, average_mark) VALUES (?1,?2,?3,?4)";


    private EntityManager entityManager = Persistence.createEntityManagerFactory("com.cbs.edu.jpa").createEntityManager();



    @Override
    public String getNameById(Integer id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query nativeQuery = entityManager.createNativeQuery("SELECT first_name FROM students WHERE id = ?1", Student.class)
                .setParameter(1, id);
        String name = (String) nativeQuery.getSingleResult();

        transaction.commit();
        return name;
    }

    @Override
    public Student get(Integer id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query nativeQuery = entityManager.createNativeQuery(SELECT_QUERY, Student.class)
                .setParameter(1, id);
        Student student = (Student) nativeQuery.getSingleResult();

        transaction.commit();
        return student;
    }

    @Override
    public Student create(Student student) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.createNativeQuery(INSERT_QUERY)
                .setParameter(1, student.getFirstName())
                .setParameter(2, student.getLastName())
                .setParameter(3, student.getAge())
                .setParameter(4, student.getAverageMark())
                .executeUpdate();

        transaction.commit();
        return student;
    }

    @Override
    public Student update(Student student) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.createNativeQuery(UPDATE_QUERY)
                .setParameter(1, student.getFirstName())
                .setParameter(2, student.getLastName())
                .setParameter(3, student.getAge())
                .setParameter(4, student.getAverageMark())
                .executeUpdate();

        transaction.commit();
        return student;
    }

    @Override
    public void delete(Integer id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.createNativeQuery(DELETE_QUERY)
                .setParameter(1, id)
                .executeUpdate();

        transaction.commit();
    }

    @Override
    public List<Student> getAll() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query nativeQuery = entityManager.createNativeQuery(SELECT_ALL_QUERY, Student.class);
        List<Student> resultList = nativeQuery.getResultList();

        transaction.commit();

        return resultList;
    }
}
