package com.example.befinalexam.services;
import com.example.befinalexam.controller.ProductFillter;
import com.example.befinalexam.model.ErrorException;
import com.example.befinalexam.model.Product;
import com.example.befinalexam.model.Type;
import com.example.befinalexam.repository.ErrorCode;
import com.example.befinalexam.repository.ErrorCodeException;
import com.example.befinalexam.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {
    ProductRepository repository;

    @Override
    public Page<Product> findAll(ProductFillter fillter,Pageable pageable) {
        return repository.findAll(fillter,pageable);
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(
                ()-> new ErrorCodeException(ErrorCode.PRODUCT_NOT_FOUND,"Product not found with "+id));
    }

    @Override
    public List<Product>  findAllProducts() {
        return repository.findAllProducts();
    }


    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public void deletebyId(Long id) {
        repository.deleteById(id);
    }
}
