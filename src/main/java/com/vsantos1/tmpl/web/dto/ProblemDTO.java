package com.vsantos1.tmpl.web.dto;

import java.util.Date;
import java.util.HashMap;

import org.springframework.http.HttpStatus;

public record ProblemDTO(String uri, String message,Date timestamp, HttpStatus status,HashMap<String, String> errors) {
    
}
