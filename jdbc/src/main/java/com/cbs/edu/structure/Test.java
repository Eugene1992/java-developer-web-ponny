package com.cbs.edu.structure;

import com.cbs.edu.structure.dao.UserDAO;
import com.cbs.edu.structure.dao.impl.UserDAOImpl;
import com.cbs.edu.structure.entities.Product;
import com.cbs.edu.structure.entities.User;
import com.cbs.edu.structure.orm.EntityManager;

import java.util.List;

public class Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        UserDAO dao = new UserDAOImpl();

        EntityManager entityManager = new EntityManager();

        List<User> users = entityManager.getAll(User.class);

        List<Product> products = entityManager.getAll(Product.class);

        System.out.println(dao.getAll());
    }
}
