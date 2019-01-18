package com.cbsystematics.edu.internet_shop.dao;

import com.cbsystematics.edu.internet_shop.entities.User;

public interface UserDAO extends DAO<User> {

    User getByUsernameAndPassword(String username, String password);

}
