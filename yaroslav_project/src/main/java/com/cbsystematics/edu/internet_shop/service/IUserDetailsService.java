package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.entities.UserDetails;

import java.util.List;

public interface IUserDetailsService {

    List<UserDetails> getAll();

    UserDetails get(Integer id);

    void delete(Integer id);

    void update(UserDetails userDetails);

    UserDetails create(UserDetails userDetails);

}
