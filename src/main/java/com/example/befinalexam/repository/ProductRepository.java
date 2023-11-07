package com.example.befinalexam.repository;

import com.example.befinalexam.controller.ProductFillter;
import com.example.befinalexam.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Page<Product> findAll(ProductFillter fillter,Pageable pageable);
    Optional<Product> findById(Long id);
    List<Product> findAllProducts();
    Product save(Product product);

    void deleteById(Long id);
}
