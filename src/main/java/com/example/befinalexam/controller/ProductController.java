package com.example.befinalexam.controller;
import com.example.befinalexam.model.Product;
import com.example.befinalexam.services.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/product")
@RestController
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin("*")
public class ProductController {
    ProductService service;
    ProductMapper mapper;
    @GetMapping
    public Page<ProductResp> getAll(ProductFillter fillter,Pageable pageable){
        return service.findAll(fillter,pageable).map(mapper::toProductResp);
    }
    @GetMapping("{id}")
    public ProductResp getById(@PathVariable  Long id){
        return  service.findById(id).transform(mapper::toProductResp);
    }
    @PostMapping("create")
    public ProductResp create(@RequestBody ProductReq productReq){
        return  productReq.transform(mapper::toProduct)
                .transform(service::save)
                .transform(mapper::toProductResp);
    }
    @DeleteMapping("{id}")
    public  void delete(@PathVariable Long id){
        service.deletebyId(id);
    }
    @GetMapping("getall")
    public List<Product> getAllProducts(){
        return service.findAllProducts();
    }
}
