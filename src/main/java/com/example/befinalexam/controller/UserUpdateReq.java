package com.example.befinalexam.controller;

import com.example.befinalexam.model.Role;

public record UserUpdateReq(
        String username,
        String email,
        Role role
) {
}
