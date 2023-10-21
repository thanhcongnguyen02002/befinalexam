package com.example.befinalexam.services;

import com.example.befinalexam.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);

    Product save(Product product);

    void deletebyId(Long id);
}
