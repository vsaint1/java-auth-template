package com.vsantos1.tmpl.web.service.auth;

import java.time.Instant;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.vsantos1.tmpl.web.dto.AuthenticationDTO;
import com.vsantos1.tmpl.web.dto.JwtTokenDTO;

@Service
public class JwtService {

    private final JwtEncoder jwtEncoder;

    public JwtService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public JwtTokenDTO generateToken(AuthenticationDTO auth) {
        Instant now = Instant.now();
        long expiration = 36000L; // 10h
        Instant expiresAt = now.plusSeconds(expiration);
        var claims = JwtClaimsSet.builder()
                .issuer("spring-test-security")
                .issuedAt(now)
                .expiresAt(expiresAt)
                .subject(auth.email())
                .claim("scope","read")
                .build();

        var token = this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new JwtTokenDTO(token, now, expiresAt);

    }
}
