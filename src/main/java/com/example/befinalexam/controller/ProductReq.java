package com.example.befinalexam.controller;


import com.example.befinalexam.model.Type;

import java.util.function.Function;

public record ProductReq(
        String productname,
        String description,
        double price,
        String image,
        Type type
) {
    public <R> R transform(Function<? super ProductReq, ? extends R> func) {
        return func.apply(this);
    }

}
