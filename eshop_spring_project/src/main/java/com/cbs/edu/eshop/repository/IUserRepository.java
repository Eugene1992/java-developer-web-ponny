package com.cbs.edu.eshop.repository;

import com.cbs.edu.eshop.entity.User;

public interface IUserRepository extends GenericRepository<User> {
    User getByUsername(String username);
}
