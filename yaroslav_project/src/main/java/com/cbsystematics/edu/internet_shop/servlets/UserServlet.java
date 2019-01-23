package com.cbsystematics.edu.internet_shop.servlets;

import com.cbsystematics.edu.internet_shop.entities.Role;
import com.cbsystematics.edu.internet_shop.entities.User;
import com.cbsystematics.edu.internet_shop.entities.UserDetails;
import com.cbsystematics.edu.internet_shop.service.IUserService;
import com.cbsystematics.edu.internet_shop.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/admin/users",
        initParams = {
                @WebInitParam(name = "userPaginationSize", value = "10")
        })
public class UserServlet extends HttpServlet {

    private IUserService userService;

    public UserServlet() {
        this.userService = new UserService();
    }


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
                        userService.deleteUser(Integer.parseInt(idParam));
                    }
                    break;
                }
                case "update": {
                    String idParam = req.getParameter("id");
                    if(idParam != null && !idParam.isEmpty()) {
                        User updUser = userService.getUser(Integer.parseInt(idParam));
                        req.setAttribute("updUser", updUser);
                        req.getRequestDispatcher("/new_user.jsp").forward(req, resp);
                    }
                    break;
                }
            }
        }
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
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
        String idParam = req.getParameter("user_id");
        if (idParam != null && !idParam.isEmpty()) {
            id = Integer.parseInt(idParam);
            user = new User(id, username, password);
            user.setUserDetails(new UserDetails(firstName, lastName, email, phone));
            user.setRole(new Role(roleName));
            userService.updateUser(user);
        } else {
            user = new User(username, password);
            user.setUserDetails(new UserDetails(firstName, lastName, email, phone));
            user.setRole(new Role(roleName));
            userService.createUser(user);
        }

        req.setAttribute("users", userService.getAll());
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);

    }
}
