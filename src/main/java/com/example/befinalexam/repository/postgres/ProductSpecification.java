package com.example.befinalexam.repository.postgres;

import com.example.befinalexam.controller.ProductFillter;
import com.example.befinalexam.model.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public  final class ProductSpecification {
    public  static Specification<Product> withFillter(ProductFillter fillter){
        return Specification.where(withName(fillter.productname()));
    }

    private static Specification<Product> withName(String productname) {
        if(productname== null){
            return  null;
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("productname"),"%" +productname+"%");
    }
}
