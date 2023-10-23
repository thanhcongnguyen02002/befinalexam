package com.example.befinalexam.controller;
import com.example.befinalexam.model.Role;
public record UserReq(
        String username,
        String email,
        Role role
) {
}
