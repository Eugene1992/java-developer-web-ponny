package com.cbsystematics.edu.homework05.dao.impl;


import com.cbsystematics.edu.homework05.dao.StudentDAO;
import com.cbsystematics.edu.homework05.entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class JPQLStudentDAOImpl implements StudentDAO {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("com.cbs.edu.jpa").createEntityManager();



    @Override
    public String getNameById(Integer serialNumber) {
        return null;
    }

    @Override
    public Student get(Integer id) {
        return null;
    }

    @Override
    public Student create(Student entity) {
        return null;
    }

    @Override
    public Student update(Student entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Student> getAll() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createQuery("from Student");
        List<Student> resultList = query.getResultList();

        transaction.commit();

        return resultList;
    }
}
