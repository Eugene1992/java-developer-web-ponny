package com.cbsystematics.edu.internet_shop.dao.jdbc;

import com.cbsystematics.edu.internet_shop.entities.Role;

public interface RoleDAO extends DAOJDBC<Role> {
    int getIdByRoleName(String roleName);
}
