package com.vsantos1.tmpl.web.service.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vsantos1.tmpl.web.model.Authority;
import com.vsantos1.tmpl.web.repository.AuthorityRepository;

@Service
public class AuthorityService {


    private final AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public Optional<Authority> findByName(String name) {

        var authority = authorityRepository.findByName(name);

        if (authority.isPresent()) {
            throw new IllegalArgumentException("Authority not found");
        }

        return authority;
    }

    public void create(Authority authority) {


        authorityRepository.save(authority);

    }

}
