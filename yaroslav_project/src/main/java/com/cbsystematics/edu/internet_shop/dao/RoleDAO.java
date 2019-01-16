package com.cbsystematics.edu.internet_shop.dao;

import com.cbsystematics.edu.internet_shop.entities.Role;

public interface RoleDAO extends DAO<Role> {
    Role getRoleByName(String name);
}
