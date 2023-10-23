package com.example.befinalexam.controller;


import com.example.befinalexam.model.Type;

public record ProductResp(
        Long id,
        String productname,
        String description,
        double price,
        String image,
        Type type
) {
}
