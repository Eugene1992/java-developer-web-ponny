package com.cbsystematics.edu.eshop.service;

import com.cbsystematics.edu.eshop.entities.User;

import java.util.List;

public interface IUserService {
    User createUser(User user);
    User updateUser(User user);
    User getUser(Integer id);
    void deleteUser(Integer id);
    List<User> getAllUsers();
}
