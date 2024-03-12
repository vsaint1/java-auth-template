package com.vsantos1.tmpl.web.service;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import com.vsantos1.tmpl.web.model.Category;
import com.vsantos1.tmpl.web.repository.CrudRepository;

@Service
public class CategoryService implements CrudRepository<Category, Long> {

    private JdbcClient jdbc;

    public CategoryService(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void deleteById(Long id) {
        jdbc.sql("DELETE FROM tb_category WHERE id = :id")
                .param("id", id).update();

    }

    @Override
    public List<Category> findAll() {

        var categories = jdbc.sql("SELECT * FROM tb_category")
                .query(Category.class).list();

        return categories;
    }


    @Override
    public Category findById(Long id) {
        var category = jdbc.sql("SELECT * FROM tb_category WHERE id = :id")
                .param("id", id)
                .query(Category.class).optional();

        if (category.isEmpty()) {
            throw new IllegalArgumentException("Category not found");
        }

        return category.get();
    }

    @Override
    public Category save(Category entity) {

        jdbc.sql("INSERT INTO tb_category (name) VALUES (:name)")
                .param("name", entity.getName())
                .update();

        return entity;
    }

    @Override
    public void update(Category entity) {

        jdbc.sql("UPDATE tb_category SET name = :name WHERE id = :id")
                .param("id", entity.getId())
                .param("name", entity.getName())
                .update();

    }

}
