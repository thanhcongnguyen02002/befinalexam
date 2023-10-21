package com.example.befinalexam.repository;

import com.example.befinalexam.model.Type;

import java.util.List;

public interface TypeRepository {
    List<Type> findAll();
    Type save(Type type);
}
