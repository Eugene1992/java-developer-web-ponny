package com.cbs.edu.jdbc.examples.structure.dao;

import com.cbs.edu.jdbc.examples.structure.entities.User;

public interface UserDAO extends DAO<User>{
    User getByUsername(String username);
}