package com.vsantos1.tmpl.web.dto;

import java.time.Instant;

public record JwtTokenDTO(String token, Instant createdAt, Instant expiration) {
    
}
