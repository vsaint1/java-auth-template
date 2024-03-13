package com.vsantos1.tmpl.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsantos1.tmpl.web.dto.AuthenticationDTO;
import com.vsantos1.tmpl.web.dto.JwtTokenDTO;
import com.vsantos1.tmpl.web.service.auth.AuthenticationService;

@RestController
@RequestMapping("/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public JwtTokenDTO authenticateUser(@RequestBody AuthenticationDTO auth) {
        return this.authenticationService.authenticate(auth);

    }
}
