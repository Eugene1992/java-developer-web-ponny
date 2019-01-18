package com.cbsystematics.edu.internet_shop.servlets;

import com.cbsystematics.edu.internet_shop.dto.CreateUserDTO;
import com.cbsystematics.edu.internet_shop.service.IUserService;
import com.cbsystematics.edu.internet_shop.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserRegisterServlet extends HttpServlet {

    private IUserService userService;

    public UserRegisterServlet() {
        this.userService = new UserService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/new_user_register_form.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String confirmPassword = req.getParameter("re_password"); // TODO: 11.01.2019 validate
        String email = req.getParameter("email");

        CreateUserDTO user = new CreateUserDTO(firstName, lastName, username, email, phone, password, confirmPassword);

        userService.registerUser(user);

        req.getRequestDispatcher("/new_user_register_form.jsp").forward(req, resp);
    }
}
