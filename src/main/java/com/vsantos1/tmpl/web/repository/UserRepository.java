package com.vsantos1.tmpl.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsantos1.tmpl.web.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}