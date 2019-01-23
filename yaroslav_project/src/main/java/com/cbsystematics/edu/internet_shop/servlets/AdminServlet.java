package com.cbsystematics.edu.internet_shop.servlets;

import com.cbsystematics.edu.internet_shop.entities.*;
import com.cbsystematics.edu.internet_shop.service.IDiscountService;
import com.cbsystematics.edu.internet_shop.service.IProductService;
import com.cbsystematics.edu.internet_shop.service.IUserService;
import com.cbsystematics.edu.internet_shop.service.impl.DiscountService;
import com.cbsystematics.edu.internet_shop.service.impl.ProductService;
import com.cbsystematics.edu.internet_shop.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private IDiscountService discountService = new DiscountService();
    private IProductService productService = new ProductService();
    private IUserService userService = new UserService();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqParameter = req.getParameter("action");
        if (reqParameter != null && !reqParameter.isEmpty()) {
            switch (reqParameter) {
                case "createUser": {
                    req.getRequestDispatcher("/new_user.jsp").forward(req, resp);
                    break;
                }
                case "deleteUser": {
                    String idParam = req.getParameter("id");
                    if(idParam != null && !idParam.isEmpty()) {
                        userService.deleteUser(Integer.parseInt(idParam));
                    }
                    break;
                }
                case "updateUser": {
                    String idParam = req.getParameter("id");
                    if(idParam != null && !idParam.isEmpty()) {
                        User updUser = userService.getUser(Integer.parseInt(idParam));
                        req.setAttribute("updUser", updUser);
                        req.getRequestDispatcher("/new_user.jsp").forward(req, resp);
                    }
                    break;
                }
                case "createDiscount": {
                    req.getRequestDispatcher("/new_discount.jsp").forward(req, resp);
                    break;
                }
                case "deleteDiscount": {
                    String idParam = req.getParameter("id");
                    if(idParam != null && !idParam.isEmpty()) {
                        discountService.delete(Integer.parseInt(idParam));
                    }
                    break;
                }
                case "updateDiscount": {
                    String idParam = req.getParameter("id");
                    if(idParam != null && !idParam.isEmpty()) {
                        Discount updDiscount = discountService.get(Integer.parseInt(idParam));
                        req.setAttribute("updDiscount", updDiscount);
                        req.getRequestDispatcher("/new_discount.jsp").forward(req, resp);
                    }
                    break;
                }
                case "createProduct": {
                    req.getRequestDispatcher("/new_product.jsp").forward(req, resp);
                    break;
                }
                case "deleteProduct": {
                    String idParam = req.getParameter("id");
                    if(idParam != null && !idParam.isEmpty()) {
                        productService.delete(Integer.parseInt(idParam));
                    }
                    break;
                }
                case "updateProduct": {
                    String idParam = req.getParameter("id");
                    if(idParam != null && !idParam.isEmpty()) {
                        Product updProduct = productService.get(Integer.parseInt(idParam));
                        req.setAttribute("updProduct", updProduct);
                        req.getRequestDispatcher("/new_product.jsp").forward(req, resp);
                    }
                    break;
                }
            }
        }
        req.setAttribute("users", userService.getAll());
        req.setAttribute("products", productService.getAll());
        req.setAttribute("discounts", discountService.getAll());
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("user_id") != null) {
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
        }


        if(req.getParameter("product_id") != null) {
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            Integer price = Integer.valueOf(req.getParameter("price"));
            String category = req.getParameter("category");
            String imgUrl = req.getParameter("imgUrl");
            int productId;
            Product product;
            String productIdParam = req.getParameter("product_id");
            if (productIdParam != null && !productIdParam.isEmpty()) {
                productId = Integer.parseInt(productIdParam);
                product = new Product(productId, title, description, category, price, imgUrl);
                productService.update(product);
            } else {
                product = new Product(title, description, category, price, imgUrl);
                productService.create(product);
            }
        }


        if(req.getParameter("discount_id") != null) {
            String name = req.getParameter("name");
            double amount = Double.parseDouble(req.getParameter("amount"));
            int discountId;
            Discount discount;
            String discountIdParam = req.getParameter("discount_id");
            if (discountIdParam != null && !discountIdParam.isEmpty()) {
                discountId = Integer.parseInt(discountIdParam);
                discount = new Discount(discountId, name, amount);
                discountService.update(discount);
            } else {
                discount = new Discount(name, amount);
                discountService.create(discount);
            }
        }

        req.setAttribute("users", userService.getAll());
        req.setAttribute("products", productService.getAll());
        req.setAttribute("discounts", discountService.getAll());
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }
}
