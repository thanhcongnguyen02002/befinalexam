package com.example.befinalexam.controller;
import com.example.befinalexam.model.Product;
import com.example.befinalexam.model.Type;
import com.example.befinalexam.services.TypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/type")
@RestController
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin("*")
public class TypeController {
    TypeService service;
    ProductMapper productMapper;
    TypeMapper typeMapper;

    @GetMapping
    public Page<TypeResp> getAll(Pageable pageable){
        return  service.getAll(pageable).map(typeMapper::toTypeResp);
    }

    @PostMapping("/create")
    public Type create( @RequestBody Type type){
        return service.create(type);
    }
    @PostMapping("{id}/product")
    public  Type addProduct(@PathVariable Long id,@RequestBody Product product){
        return service.addProduct(id,product);
    }
    @DeleteMapping("{id}")
    public  void deleteById(@PathVariable  Long id){
        service.deleteById(id);
    }
    @PatchMapping("update/{id}")
    public TypeResp update(@PathVariable Long id,@RequestBody TypeUpdateReq req){
        var exists= service.findbyId(id);
        typeMapper.update(req,exists);
        return  exists.transform(service::create)
                .transform(typeMapper::toTypeResp);
    }

}
