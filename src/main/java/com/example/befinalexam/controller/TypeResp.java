package com.example.befinalexam.controller;

import java.util.Set;

public record TypeResp(
        Long id,
        String name,

        Set<ProductResp> products
) {
}
