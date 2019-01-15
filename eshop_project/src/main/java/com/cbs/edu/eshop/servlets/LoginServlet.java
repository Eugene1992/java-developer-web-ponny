package com.cbs.edu.eshop.servlets;

import com.cbs.edu.eshop.entity.User;
import com.cbs.edu.eshop.service.IUserService;
import com.cbs.edu.eshop.service.impl.IUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private IUserService userService;

    public LoginServlet() {
        this.userService = new IUserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        User user = userService.getByUsernameAndPassword(username, password);
        System.out.println(user);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setMaxInactiveInterval(30);
            session.setAttribute("user", user);
            resp.sendRedirect("/");
        } else {
            req.setAttribute("errMsg", "Wrong login or password");
            req.getRequestDispatcher("/").forward(req, resp);
        }
    }
}
