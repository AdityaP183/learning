package com.auth.learning.dtos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;

public record ErrorResponse(
    Instant timestamp,
    String message,
    HttpStatus status
) {
}
