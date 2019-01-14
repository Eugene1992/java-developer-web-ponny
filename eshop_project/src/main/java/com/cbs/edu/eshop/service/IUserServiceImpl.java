package com.cbs.edu.eshop.service;

import com.cbs.edu.eshop.dao.IUserDAOImpl;
import com.cbs.edu.eshop.dto.CreateUserDTO;
import com.cbs.edu.eshop.entity.User;

import java.util.List;

public class IUserServiceImpl implements IUserService {

    private IUserDAOImpl userDAO;

    public IUserServiceImpl() {
        this.userDAO = new IUserDAOImpl();
    }

    @Override
    public User createUser(CreateUserDTO userDTO) {
        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            throw new IllegalArgumentException(""); // TODO: 11.01.2019 make own exception class
        }

        User user = new User(
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getUsername(),
                userDTO.getEmail(),
                userDTO.getPassword()
        );

        return userDAO.create(user);
    }

    @Override
    public User updateUser(User user) {
        return userDAO.update(user);
    }

    @Override
    public User getUser(Integer id) {
        return userDAO.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    @Override
    public void deleteUser(Integer id) {
        userDAO.delete(id);
    }
}
