package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.entities.Role;

import java.util.List;

public interface IRoleService {

    List<Role> getAll();

    Role get(Integer id);

    void delete(Integer id);

    void update(Role role);

    Role create(Role role);
}
