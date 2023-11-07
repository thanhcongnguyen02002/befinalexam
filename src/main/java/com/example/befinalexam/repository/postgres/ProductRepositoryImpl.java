package com.example.befinalexam.repository.postgres;

import com.example.befinalexam.controller.ProductFillter;
import com.example.befinalexam.model.Product;
import com.example.befinalexam.model.ProductType;
import com.example.befinalexam.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Repository
@Component
@Primary
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductRepositoryImpl implements ProductRepository {
    ProductJpaRepository jpaRepository;

    @Override
    public Page<Product> findAll(ProductFillter fillter,Pageable pageable) {
        var spec= ProductSpecification.withFillter(fillter);
        return jpaRepository.findAll(spec,pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Product> findAllProducts() {
        List<Object> objects = jpaRepository.getProductsBy();
        for (Object object: objects) {
            ProductType productType = (ProductType) object;
            System.out.println(productType);
        }
        return new ArrayList<>();
    }

    @Override
    public Product save(Product product) {
        return jpaRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

}
