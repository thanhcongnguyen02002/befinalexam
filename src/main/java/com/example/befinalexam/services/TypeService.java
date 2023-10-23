package com.example.befinalexam.services;

import com.example.befinalexam.model.Product;
import com.example.befinalexam.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TypeService {
    Page<Type> getAll(Pageable pageable);
    Type findbyId(Long id);
    Type create(Type type);
    Type addProduct(Long id, Product product);

    void deleteById(Long id);

    Type update(Type type);
}
