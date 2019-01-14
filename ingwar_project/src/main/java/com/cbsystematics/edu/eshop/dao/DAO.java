package com.cbsystematics.edu.eshop.dao;

import com.cbsystematics.edu.eshop.entities.AbstractEntity;

import java.util.List;

public interface DAO <E extends AbstractEntity> {

    E get (Integer id);

    E create (E entity);

    E update (E entity);

    void delete (Integer id);

    List <E> getAll();

}
