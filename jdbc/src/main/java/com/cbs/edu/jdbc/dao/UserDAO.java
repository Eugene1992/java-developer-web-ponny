package com.cbs.edu.jdbc.dao;

import java.util.List;

public interface UserDAO {
    User getUser(Integer id);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Integer id);

    List<User> getAllUsers();

    List<User> getUsersBySalaryInterval(Integer from, Integer to);
}
