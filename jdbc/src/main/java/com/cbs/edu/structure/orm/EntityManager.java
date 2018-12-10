package com.cbs.edu.structure.orm;

import java.util.Collections;
import java.util.List;

public class EntityManager {

    public <T> List<T> getAll(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return Collections.emptyList();
    }

    public <T> List<T> create(T obj) throws IllegalAccessException, InstantiationException {
        String q = "INSERT INTO @Table.name()(id,...) VALUES ()";
        return Collections.emptyList();
    }

    public <T, ID> T get(ID id, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        String q = "INSERT INTO @Table.name()(id,...) VALUES ()";
        return null;
    }
}