package com.cbsystematics.edu.internet_shop.servlets;

import com.cbsystematics.edu.internet_shop.entities.Role;
import com.cbsystematics.edu.internet_shop.entities.User;
import com.cbsystematics.edu.internet_shop.entities.UserDetails;
import com.cbsystematics.edu.internet_shop.service.IUserService;
import com.cbsystematics.edu.internet_shop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    private IUserService service = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqParameter = req.getParameter("action");
        if (reqParameter != null && !reqParameter.isEmpty()) {
            switch (reqParameter) {
                case "create": {
                    req.getRequestDispatcher("/new_user.jsp").forward(req, resp);
                    break;
                }
                case "delete": {
                    String idParam = req.getParameter("id");
                    if(idParam != null && !idParam.isEmpty()) {
                        service.delete(Integer.parseInt(idParam));
                    }
                    break;
                }
                case "update": {
                    String idParam = req.getParameter("id");
                    if(idParam != null && !idParam.isEmpty()) {
                        User updUser = (User) service.get(Integer.parseInt(idParam));
                        req.setAttribute("updUser", updUser);
                        req.getRequestDispatcher("/new_user.jsp").forward(req, resp);
                    }
                    break;
                }
            }
        }

        req.setAttribute("users", service.getAll());
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String roleName = req.getParameter("role");
        System.out.println(roleName);
        int id;
        User user ;
        String idParam = req.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            id = Integer.parseInt(idParam);
            user = new User(id, username, password);
            user.setUserDetails(new UserDetails(firstName, lastName, email, phone));
            user.setRole(new Role(roleName));
            service.update(user);
        } else {
            user = new User(username, password);
            user.setUserDetails(new UserDetails(firstName, lastName, email, phone));
            user.setRole(new Role(roleName));
            service.create(user);
        }

        req.setAttribute("users", service.getAll());
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }
}
