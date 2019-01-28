package com.cbsystematics.edu.internet_shop.repository;


import com.cbsystematics.edu.internet_shop.entity.User;

public interface IUserRepository extends GenericRepository<User> {

    User getByUsernameAndPassword(String username, String password);

}
