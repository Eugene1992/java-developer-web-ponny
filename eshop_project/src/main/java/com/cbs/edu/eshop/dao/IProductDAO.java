package com.cbs.edu.eshop.dao;

import com.cbs.edu.eshop.entity.AbstractEntity;
import com.cbs.edu.eshop.entity.Product;

public interface IProductDAO<T extends AbstractEntity> extends GenericDAO<Product> {
}
