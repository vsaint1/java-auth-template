package com.vsantos1.tmpl.web.service.user;

import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vsantos1.tmpl.web.model.User;
import com.vsantos1.tmpl.web.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final AuthorityService authorityService;

    public UserService(UserRepository userRepository, AuthorityService authorityService) {
        this.userRepository = userRepository;
        this.authorityService = authorityService;
    }

    public Optional<User> findByEmail(String email) {
        var user = userRepository.findByEmail(email);

        if (user.isEmpty())
            throw new UsernameNotFoundException("User not found");

        return user;

    }

    public User save(User entity) {
        var encoder = new BCryptPasswordEncoder();
        entity.setPassword(encoder.encode(entity.getPassword()));
        entity.getAuthorities().add(authorityService.findByName("ROLE_USER").get());
        userRepository.save(entity);


        return entity;
    }

}
