package com.example.befinalexam.services;

import com.example.befinalexam.model.Type;

import java.util.List;

public interface TypeService {
    List<Type> getAll();
    Type create(Type type);
}
