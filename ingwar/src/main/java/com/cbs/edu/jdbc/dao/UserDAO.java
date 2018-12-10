package com.cbs.edu.jdbc.dao;

import com.cbs.edu.jdbc.objects.User;

public interface UserDAO extends DAO<User> {
    User getByUsername (String username);

}
