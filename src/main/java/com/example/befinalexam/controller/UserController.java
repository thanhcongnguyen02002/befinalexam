package com.example.befinalexam.controller;

import com.example.befinalexam.model.User;
import com.example.befinalexam.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/user")
@RestController
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin("*")
public class UserController {
    UserService service;
    UserMapper mapper;
    @GetMapping
    public List<User> findAll(){
        return  service.getAll();
    }
    @PostMapping("/create")
    public User create(@RequestBody   User user){
        return  service.save(user);
    }
    @GetMapping("{id}")
    public User getById(@PathVariable Long id){
        return service.findById(id);
    }
    @DeleteMapping("{id}")
    public  void deleteById(@PathVariable  Long id){
        service.deleteById(id);
    }
    @PatchMapping("update/{id}")
    public  UserResp updateUser(@PathVariable Long id,@RequestBody UserUpdateReq req){
        var check = service.findById(id);
        mapper.update(req, check);
        return check.transform(service::save)
                .transform(mapper::toUserResp);
    }
}
