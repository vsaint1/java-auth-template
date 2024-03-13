package com.vsantos1.tmpl.web.service.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vsantos1.tmpl.web.dto.AuthenticationDTO;
import com.vsantos1.tmpl.web.dto.JwtTokenDTO;
import com.vsantos1.tmpl.web.service.user.UserService;

@Service
public class AuthenticationService {

    private final JwtService jwtService;

    private final UserService userService;

    public AuthenticationService(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    public JwtTokenDTO authenticate(AuthenticationDTO auth) {
        var user = userService.findByEmail(auth.email());

        var bcrypt = new BCryptPasswordEncoder();
        if (!bcrypt.matches(auth.password(), user.get().getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        return jwtService.generateToken(auth);
    }
}
