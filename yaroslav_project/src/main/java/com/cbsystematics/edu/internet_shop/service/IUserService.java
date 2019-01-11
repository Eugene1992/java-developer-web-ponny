package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.entities.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    User get(Integer id);

    void delete(Integer id);

    void update(User user);

    User create(User user);
}
