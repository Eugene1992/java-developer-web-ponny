package com.cbs.edu.jdbc.examples.dao;

import com.cbs.edu.jdbc.objects.User;

public interface UserDAO extends DAO<User> {
    User getByUsername (String username);

}
