package com.vsantos1.tmpl.web.repository;

import java.util.List;

public interface CrudRepository<T,ID> {
    

    T findById(ID id);

    T save(T entity);

    List<T> findAll();

    void update(T entity);

    void deleteById(ID id);

}
