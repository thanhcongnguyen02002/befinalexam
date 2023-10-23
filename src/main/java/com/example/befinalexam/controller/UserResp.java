package com.example.befinalexam.controller;
import com.example.befinalexam.model.Role;
public record UserResp(
        Long id,
        String username,
        String email,
        Role role
) {
}
