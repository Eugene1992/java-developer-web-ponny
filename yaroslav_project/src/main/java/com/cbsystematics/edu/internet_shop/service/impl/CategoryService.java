package com.cbsystematics.edu.internet_shop.service.impl;

import com.cbsystematics.edu.internet_shop.dao.CategoryDAO;
import com.cbsystematics.edu.internet_shop.dao.impl.CategoryDAOImpl;
import com.cbsystematics.edu.internet_shop.entities.Category;
import com.cbsystematics.edu.internet_shop.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {

    private CategoryDAO categoryDAO;

    public CategoryService() {
        this.categoryDAO = new CategoryDAOImpl();
    }

    @Override
    public List<Category> getAll() {
        return categoryDAO.getAll();
    }

    @Override
    public Category get(Integer id) {
        return categoryDAO.get(id);
    }

    @Override
    public void delete(Integer id) {
        categoryDAO.delete(id);
    }

    @Override
    public void update(Category category) {
        categoryDAO.update(category);
    }

    @Override
    public Category create(Category category) {
        categoryDAO.create(category);
        return category;
    }
}
