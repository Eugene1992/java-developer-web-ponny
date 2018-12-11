package com.cbs.edu.structure.dao;

import com.cbs.edu.structure.entities.User;

public interface UserDAO extends DAO<User>{
    User getByUsername(String username);
}