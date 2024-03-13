package com.vsantos1.tmpl.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsantos1.tmpl.web.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
