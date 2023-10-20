package com.example.befinalexam.repository;

public record ErrorReponse(
        int status,
        String code,
        String message,
        String description
) {
}
