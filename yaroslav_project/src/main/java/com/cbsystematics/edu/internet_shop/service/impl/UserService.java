package com.cbsystematics.edu.internet_shop.service.impl;

import com.cbsystematics.edu.internet_shop.dao.UserDAO;
import com.cbsystematics.edu.internet_shop.dao.impl.UserDAOImpl;
import com.cbsystematics.edu.internet_shop.dto.CreateUserDTO;
import com.cbsystematics.edu.internet_shop.entities.Role;
import com.cbsystematics.edu.internet_shop.entities.RoleEnum;
import com.cbsystematics.edu.internet_shop.entities.User;
import com.cbsystematics.edu.internet_shop.entities.UserDetails;
import com.cbsystematics.edu.internet_shop.service.IUserService;

import java.util.List;

public class UserService implements IUserService {

    private UserDAO userDAO;
    private RoleService roleService;
    private UserDetailsService userDetailsService;

    public UserService() {
        this.userDAO = new UserDAOImpl();
        this.roleService = new RoleService();
        this.userDetailsService = new UserDetailsService();
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    @Override
    public User getUser(Integer id) {
        User user = userDAO.get(id);
        //UserDetails userDetails = userDetailsService.get(id);
        //user.setUserDetails(userDetails);
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        userDAO.delete(id);
        userDetailsService.delete(id);
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        return userDAO.getByUsernameAndPassword(username, password);
    }

    @Override
    public User updateUser(User user) {
        Role userRole = roleService.getRoleByName(user.getRole().getName());
        user.setRole(userRole);
        UserDetails userDetails = user.getUserDetails();
        System.out.println(userDetails);
        //UserDetails userDetails = userDetailsService.get(user.getId());
        //user.setUserDetails(userDetails);
        userDetailsService.update(userDetails);
        userDAO.update(user);
        return user;
    }

    @Override
    public User registerUser(CreateUserDTO userDTO)  {
        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            throw new IllegalMonitorStateException("Введенные пароль и повторный пароль не сходяться.");
        }

        User user = new User(
                userDTO.getUsername(),
                userDTO.getPassword()
        );
        UserDetails userDetails = new UserDetails(
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                userDTO.getPhone());
        user.setUserDetails(userDetails);

        Role userRole = roleService.getRoleByName(RoleEnum.USER.getRole().getName());
        user.setRole(userRole);

        return userDAO.create(user);
    }

    @Override
    public User createUser(User user) {
        Role userRole = roleService.getRoleByName(user.getRole().getName());
        //System.out.println("==========" + userRole.getName());
        user.setRole(userRole);
        UserDetails userDetails = user.getUserDetails();
        user.setUserDetails(userDetails);
        return userDAO.create(user);
    }

}
