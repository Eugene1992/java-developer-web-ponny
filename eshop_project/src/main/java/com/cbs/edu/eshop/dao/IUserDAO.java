package com.cbs.edu.eshop.dao;

import com.cbs.edu.eshop.entity.AbstractEntity;
import com.cbs.edu.eshop.entity.User;

public interface IUserDAO<T extends AbstractEntity> extends GenericDAO<User> {
}
