package com.cbs.edu.eshop.servlets;

import com.cbs.edu.eshop.dto.CreateUserDTO;
import com.cbs.edu.eshop.entity.User;
import com.cbs.edu.eshop.service.IUserService;
import com.cbs.edu.eshop.service.IUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.cbs.edu.eshop.entity.RoleEnum.USER;

public class UserRegisterServlet extends HttpServlet {

    private IUserService userService;

    public UserRegisterServlet() {
        this.userService = new IUserServiceImpl();
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
        String confirmPassword = req.getParameter("re_password"); // TODO: 11.01.2019 validate
        String email = req.getParameter("email");

        CreateUserDTO user = new CreateUserDTO(firstName, lastName, username, email, password, confirmPassword);

        userService.createUser(user);

        req.getRequestDispatcher("/new_user_register_form.jsp").forward(req, resp);
    }
}
