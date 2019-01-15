package com.cbs.edu.eshop.service;

import com.cbs.edu.eshop.entity.Role;

import java.util.List;

public interface IRoleService {
    Role getRoleByName(String name);

    List<Role> getAllRoles();
}