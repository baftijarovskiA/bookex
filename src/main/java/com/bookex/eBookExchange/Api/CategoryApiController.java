package com.bookex.eBookExchange.Api;

import com.bookex.eBookExchange.Model.Category;
import com.bookex.eBookExchange.Service.Impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/category")
public class CategoryApiController {

    private CategoryServiceImpl categoryService;

    public CategoryApiController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @RequestMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") Long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category addNewCategory(@Valid @RequestBody Category category){
        return categoryService.addNewCategory(category);
    }

    @DeleteMapping("/{id}")
    public Category deleteCategoryById(@PathVariable("id") Long id){
        return categoryService.deleteCategoryById(id);
    }

    @PutMapping("/{id}")
    public Category updateCategoryById(@PathVariable("id") Long id, @Valid @RequestBody Category category){
        return categoryService.updateCategoryById(id, category);
    }

    @RequestMapping("/increase/{id}")
    public void increase(@PathVariable("id") Long id){
        categoryService.increasePopularity(id);
    }

    @RequestMapping("/decrease/{id}")
    public void decrease(@PathVariable("id") Long id){
        categoryService.decreasePopularity(id);
    }

    @RequestMapping("search/{query}")
    public List<Category> searchCategory(@PathVariable("query") String query){
        return categoryService.searchCategory(query);
    }

    @RequestMapping("/v/{state}/{categoryId}")
    public void setVisibility(@PathVariable("state") int state, @PathVariable("categoryId") Long categoryId){
        categoryService.setVisibility(state, categoryId);
    }
}

