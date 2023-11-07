package com.example.befinalexam.services;

import com.example.befinalexam.controller.ProductFillter;
import com.example.befinalexam.model.Product;
import com.example.befinalexam.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<Product> findAll(ProductFillter fillter,Pageable pageable);
    Product findById(Long id);

    List<Product> findAllProducts();
    Product save(Product product);

    void deletebyId(Long id);
}
