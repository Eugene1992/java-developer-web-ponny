package jdbc;

import jdbc.homework1.dao.impl.UserDAOImpl;
import jdbc.homework1.entities.User;

public class TesterClass {
    public static void main(String[] args) {
        User user = new User("Galya", "Gasha", "gashan", "gashan", "gal@ukr.ua");
        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.create(user);
    }
}
