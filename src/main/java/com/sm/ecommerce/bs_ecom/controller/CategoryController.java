package com.sm.ecommerce.bs_ecom.controller;


import com.sm.ecommerce.bs_ecom.model.Category;
import com.sm.ecommerce.bs_ecom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/public/categories")
    private ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    private ResponseEntity<String> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    private ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        try {
            String status = categoryService.deleteCategory(categoryId);
//            return new ResponseEntity<>(status, HttpStatus.OK);
//            return ResponseEntity.ok(status);
            return ResponseEntity.status(HttpStatus.OK).body(status);
        }catch (ResponseStatusException e){

            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("/public/categories/{categoryId}")
    private ResponseEntity<String> updateCategory(@RequestBody Category category, @PathVariable Long categoryId){

        try {

            Category savedCategory = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>("Category with categoryId: "+categoryId, HttpStatus.OK);

        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }

    }
}
