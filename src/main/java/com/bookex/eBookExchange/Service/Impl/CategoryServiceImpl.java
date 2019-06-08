package com.bookex.eBookExchange.Service.Impl;

import com.bookex.eBookExchange.Model.Category;
import com.bookex.eBookExchange.Repository.Impl.CategoryRepositoryImpl;
import com.bookex.eBookExchange.Service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepositoryImpl repository;

    public CategoryServiceImpl(CategoryRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getAllCategories() {
        return repository.getAllCategories();
    }

    @Override
    public Category getCategoryById(Long id) {
        return repository.getCategoryById(id);
    }

    @Override
    public Category addNewCategory(Category category) {
        return repository.addNewCategory(category);
    }

    @Override
    public Category deleteCategoryById(Long id) {
        return repository.deleteCategoryById(id);
    }

    @Override
    public Category updateCategoryById(Long id, Category category) {
        return repository.updateCategoryById(id, category);
    }

    @Override
    public void increasePopularity(Long id) {
        repository.increasePopularity(id);
    }

    @Override
    public void decreasePopularity(Long id) {
        repository.decreasePopularity(id);
    }

    @Override
    public List<Category> searchCategory(String query) {
        return repository.searchCategory(query);
    }

    @Override
    public void setVisibility(int state, Long categoryId) {
        repository.setVisibility(state, categoryId);
    }
}
