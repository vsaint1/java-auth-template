package com.vsantos1.tmpl.web.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vsantos1.tmpl.web.model.Category;
import com.vsantos1.tmpl.web.repository.CategoryRepository;

@Service
public class CategoryService {

    private Logger logger = LoggerFactory.getLogger(CategoryService.class);

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void deleteById(Long id) {

        categoryRepository.deleteById(id);
    }

    public List<Category> findAll() {

        var categories = categoryRepository.findAll();

        return categories;
    }

    public Category findById(Long id) {
        var category = categoryRepository.findById(id);

        if (category.isEmpty()) {
            logger.warn("Category not found");
            throw new IllegalArgumentException("Category not found");
        }

        return category.get();
    }

    public Category save(Category entity) {

        var saved = categoryRepository.save(entity);

        return saved;
    }

    public void update(Category entity) {

        var updated = categoryRepository.save(entity);

        logger.info("Category updated: {}", updated);
    }

}
