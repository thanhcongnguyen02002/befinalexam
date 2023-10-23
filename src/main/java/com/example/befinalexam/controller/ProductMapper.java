package com.example.befinalexam.controller;

import com.example.befinalexam.model.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Set;

@Mapper(componentModel="spring")
public interface ProductMapper {
    ProductResp toProductResp(Product product);
    Product toProduct(ProductReq productReq);
    Set<TypeResp> toTypeResp(Set<Product> products);
}
