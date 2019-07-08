package com.bookex.eBookExchange.Repository.Impl;

import com.bookex.eBookExchange.Model.Category;
import com.bookex.eBookExchange.Repository.CategoryRepository;
import com.bookex.eBookExchange.Repository.JpaRepository.CategoryJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private CategoryJpaRepository repository;

    public CategoryRepositoryImpl(CategoryJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getAllCategories() {
        return repository.sortedByPopularity();
    }

    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> category = repository.findById(id);
        return category.get();
    }

    @Override
    public Category addNewCategory(Category category) {

        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localTime = LocalDateTime.now();
        String localTimeString = FOMATTER.format(localTime);

        category.setCreated_at(localTimeString);
        category.setUpdated_at(localTimeString);
        category.setPopularity(1);
        category.setVisible(true);

        repository.save(category);
        return category;
    }

    @Override
    public Category deleteCategoryById(Long id) {
        Optional<Category> category = repository.findById(id);
        repository.delete(category.get());
        return category.get();
    }

    @Override
    public Category updateCategoryById(Long id, Category category) {

        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localTime = LocalDateTime.now();
        String localTimeString = FOMATTER.format(localTime);

        Category cat = repository.findById(id).get();
        cat.setName(category.getName());
        cat.setPicture(category.getPicture());
        cat.setUpdated_at(localTimeString);
        repository.save(cat);
        return cat;
    }

    @Override
    public void increasePopularity(Long id) {
        Category category = repository.findById(id).get();
        int currPopularity = category.getPopularity();
        category.setPopularity(currPopularity + 2);
        repository.save(category);
    }

    @Override
    public void decreasePopularity(Long id) {
        Category category = repository.findById(id).get();
        int currPopularity = category.getPopularity();
        if(currPopularity > 1)
            category.setPopularity(currPopularity - 2);
        repository.save(category);
    }

    @Override
    public List<Category> searchCategory(String query) {

        List<Category> categoryList = new ArrayList<>();
        for (Category item: repository.findAll()) {
            if (item.getName().toLowerCase().contains(query.toLowerCase())){
                categoryList.add(item);
            }
        }
        return categoryList;
    }

    @Override
    public void setVisibility(int state, Long categoryId) {
        Category category = repository.findById(categoryId).get();
        if (state == 1){
            category.setVisible(true);
        } else if (state == 0){
            category.setVisible(false);
        }
        repository.save(category);
    }
}
