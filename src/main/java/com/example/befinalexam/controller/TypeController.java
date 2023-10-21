package com.example.befinalexam.controller;
import com.example.befinalexam.model.Type;
import com.example.befinalexam.services.TypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.criteria.JpaCriteriaUpdate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/type")
@RestController
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin("*")
public class TypeController {
    TypeService service;
    @GetMapping
    public List<Type> getAll(){
        return  service.getAll();
    }
    @PostMapping("/create")
    public Type create(@RequestBody Type type){
        return service.create(type);
    }

}
