package jdbc.homework1.dao.impl;

import jdbc.connection_factory.ConnectionFactory;
import jdbc.homework1.dao.UserDAO;
import jdbc.homework1.entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    public static final String SELECT_ALL_FROM_USER = "SELECT firstName, lastName, userName, password, email FROM user ";

//    public UserDAOImpl() throws SQLException {
//    }
//    @Override
//    public User getByUsername(String username) {
//        return null;
//    }

    @Override
    public User get(Integer id) {
        try {
            Statement statement = ConnectionFactory.getConnection().createStatement();
            String sql;
            sql = SELECT_ALL_FROM_USER + "WHERE id = " + id;
            ResultSet res = statement.executeQuery(sql);
            User user = null;
            while (res.next()) {
                String firstName = res.getString("first_name");
                String lastName = res.getString("last_name");
                String userName = res.getString("user_name");
                String password = res.getString("password");
                String email = res.getString("email");
                user = new User(firstName, lastName, userName, password, email);
            }
            res.close();
            statement.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User create(User entity) {
        try {
            String sql = "INSER INTO user(firstName, lastName, userName, password, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(sql);
            ResultSet res = statement.executeQuery(sql);
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getUserName());
            statement.setString(4, entity.getPassword());
            statement.setString(5, entity.getEmail());
            entity.setId(res.getInt("id"));
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public User update(User entity) {
        try {
            String sql = "UPDATE user SET first_name = ?, last_name = ?, username = ?,  password = ?, email = ?";
            PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(sql);
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getUserName());
            statement.setString(4, entity.getPassword());
            statement.setString(5, entity.getEmail());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public void delete(Integer id) {
        try {
            String sql = "DELETE FROM user WHERE id = " + id;
            PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        try {
            Statement statement = ConnectionFactory.getConnection().createStatement();
            String sql;
            sql = SELECT_ALL_FROM_USER;
            ResultSet res = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();
            while (res.next()) {
                int id = res.getInt("id");
                String firstName = res.getString("first_name");
                String lastName = res.getString("last_name");
                String userName = res.getString("user_name");
                String password = res.getString("password");
                String email = res.getString("email");
                users.add(new User(id, firstName, lastName, userName, password, email));
            }
            res.close();
            statement.close();
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
