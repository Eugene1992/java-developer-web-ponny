package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.entities.Role;

import java.util.List;

public interface IRoleService {

    Role getRoleByName(String name);

    List<Role> getAllRoles();
}
