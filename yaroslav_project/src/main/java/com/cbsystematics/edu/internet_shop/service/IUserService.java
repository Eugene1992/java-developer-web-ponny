package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.entities.User;

import java.util.List;

public interface IUserService {

    User createUser(User user);

    User updateUser(User user);

    User getUser(Integer id);

    List<User> getAllUsers();

    void deleteUser(Integer id);

    User getByUsernameAndPassword(String username, String password);
}
