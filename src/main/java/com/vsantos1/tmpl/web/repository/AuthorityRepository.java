package com.vsantos1.tmpl.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsantos1.tmpl.web.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Optional<Authority> findByName(String name);

}
