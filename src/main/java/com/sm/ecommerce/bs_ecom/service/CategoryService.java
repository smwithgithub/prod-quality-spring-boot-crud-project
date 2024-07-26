package com.sm.ecommerce.bs_ecom.service;

import com.sm.ecommerce.bs_ecom.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
