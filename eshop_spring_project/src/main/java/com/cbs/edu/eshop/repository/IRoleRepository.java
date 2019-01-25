package com.cbs.edu.eshop.repository;

import com.cbs.edu.eshop.entity.Role;

public interface IRoleRepository extends GenericRepository<Role> {
    Role getByName(String name);
}
