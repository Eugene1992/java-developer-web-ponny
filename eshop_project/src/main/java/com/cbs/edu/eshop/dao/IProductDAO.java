package com.cbs.edu.eshop.dao;

import com.cbs.edu.eshop.entity.AbstractEntity;
import com.cbs.edu.eshop.entity.Product;
import com.cbs.edu.eshop.entity.User;

public interface IProductDAO<T extends AbstractEntity> extends GenericDAO<Product> {
}
