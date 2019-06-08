package com.bookex.eBookExchange.Service;

import com.bookex.eBookExchange.Model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category addNewCategory(Category category);

    Category deleteCategoryById(Long id);

    Category updateCategoryById(Long id, Category category);

    void increasePopularity(Long id);

    void decreasePopularity(Long id);

    List<Category> searchCategory(String query);

    void setVisibility(int state, Long categoryId);
}
