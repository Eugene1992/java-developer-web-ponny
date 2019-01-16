package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.entities.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getAll();

    Category get(Integer id);

    void delete(Integer id);

    void update(Category category);

    Category create(Category category);
}
