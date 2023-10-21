package com.example.befinalexam.repository.postgres;

import com.example.befinalexam.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
}
