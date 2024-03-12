package com.vsantos1.tmpl.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsantos1.tmpl.web.model.Category;
import com.vsantos1.tmpl.web.service.CategoryService;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    private CategoryService categoryService;

    private static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/new")
    public ResponseEntity<Category> create(@RequestBody Category category) {
        logger.error("Error creating category: {}", category.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
    }

}
