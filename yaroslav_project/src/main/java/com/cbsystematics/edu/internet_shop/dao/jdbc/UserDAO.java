package com.cbsystematics.edu.internet_shop.dao.jdbc;

import com.cbsystematics.edu.internet_shop.entities.User;

public interface UserDAO extends DAOJDBC<User> {
    int getDetailsIdById(Integer id);
}
