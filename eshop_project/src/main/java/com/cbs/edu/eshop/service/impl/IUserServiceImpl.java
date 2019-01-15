package com.cbs.edu.eshop.service.impl;

import com.cbs.edu.eshop.dao.impl.IUserDAOImpl;
import com.cbs.edu.eshop.dto.CreateUserDTO;
import com.cbs.edu.eshop.entity.Role;
import com.cbs.edu.eshop.entity.RoleEnum;
import com.cbs.edu.eshop.entity.User;
import com.cbs.edu.eshop.service.IUserService;

import java.util.List;

public class IUserServiceImpl implements IUserService {

    private IUserDAOImpl userDAO;
    private IRoleServiceImpl roleService;

    public IUserServiceImpl() {
        this.userDAO = new IUserDAOImpl();
        this.roleService = new IRoleServiceImpl();
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

        Role userRole = roleService.getRoleByName(RoleEnum.USER.getRole().getName());
        user.setRole(userRole);

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

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        return userDAO.getByUsernameAndPassword(username, password);
    }
}
