package com.example.befinalexam.controller;

import com.example.befinalexam.model.Product;
import com.example.befinalexam.services.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
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
    @GetMapping
    public List<Product> getAll(){
        return  service.findAll();
    }
    @GetMapping("{id}")
    public Product getById(@PathVariable  Long id){
        return  service.findById(id);
    }
    @PostMapping
    public Product create(Product product){
        return  service.save(product);
    }
    @DeleteMapping("{id}")
    public  void delete(@PathVariable Long id){
        service.deletebyId(id);
    }
}
