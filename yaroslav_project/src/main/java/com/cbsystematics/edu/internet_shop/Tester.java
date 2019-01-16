package com.cbsystematics.edu.internet_shop;


import com.cbsystematics.edu.internet_shop.dao.UserDAO;
import com.cbsystematics.edu.internet_shop.dao.impl.UserDAOImpl;
import com.cbsystematics.edu.internet_shop.entities.User;

public class Tester {
    public static void main(String[] args) {

        UserDAO userDAO = new UserDAOImpl();
        userDAO.create(new User("QWER", "nm h"));
        //ProductDAO productDAO = new ProductDAOImpl();
        //productDAO.create(new Product(1, "Iphone", "ewfeferfefrf", "smartphone", 3000));

        //RoleDAO roleDAO = new RoleDAOImpl();
        //Role user = new Role("user");
        //roleDAO.create(user);
        //Role admin = new Role("admin");
        //Role moderator = new Role("moderator");
        //roleDAO.create(admin);
        //roleDAO.create(moderator);

        //UserDetailsDAO userDetailsDAO = new UserDetailsDAOImpl();
        //UserDetails petrInfo = new UserDetails("Петр", "Петров", "pp@gmail.com", "066 - 384-56-45");
        //UserDetails ivanInfo = new UserDetails("Иван", "Иванов", "ivanivanov@gmail.com", "067 - 456-78-90");
        //UserDetails romanInfo = new UserDetails("Роман", "Романов", "roman@gmail.com", "066 - 323-43-66");
        //userDetailsDAO.create(petrInfo);
        //userDetailsDAO.create(ivanInfo);
        //userDetailsDAO.create(romanInfo);



        //User petr = new User("petr", "qwertyujhgf");
        //petr.setUserDetails(petrInfo);
        //petr.setRole(admin);
        //User ivan = new User("ivan", "ncuerlcnrsd");
        //ivan.setUserDetails(ivanInfo);
        //ivan.setRole(moderator);
        //User roman = new User("roman", "mcfjdvhtbzz");
        //roman.setUserDetails(romanInfo);
        //roman.setRole(moderator);
        //UserDAO userDao = new UserDAOImpl();
        //userDao.create(petr);
        //userDao.create(ivan);
        //userDao.create(roman);


        //List<User> userList = userDao.getAll(User.class);
        //for (User u : userList) {
        //    System.out.println(u);
        //}

        //User newUser = new User(1,"rrrfe", "xsxwx");
        //userDao.update(newUser);


    }
}
