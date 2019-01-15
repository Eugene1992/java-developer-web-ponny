package com.cbs.edu.eshop.service;

import com.cbs.edu.eshop.dto.CreateUserDTO;
import com.cbs.edu.eshop.entity.User;

import java.util.List;

public interface IUserService {
    User createUser(CreateUserDTO user);

    User updateUser(User user);

    User getUser(Integer id);

    List<User> getAllUsers();

    void deleteUser(Integer id);

    User getByUsernameAndPassword(String username, String password);
}
