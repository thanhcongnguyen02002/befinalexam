package com.example.befinalexam.controller;

import com.example.befinalexam.model.User;
import com.example.befinalexam.repository.postgres.UserSpecification;
import com.example.befinalexam.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<UserResp> findAll(UserFillter fillter,Pageable pageable){
        return  service.getAll(fillter,pageable)
                .map(mapper::toUserResp);
    }
    @PostMapping("/create")
    public User create(@RequestBody   User user){
        return  service.save(user);
    }
    @GetMapping("{id}")
    public UserResp getById(@PathVariable Long id){
        return service.findById(id)
                .transform(mapper::toUserResp);
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
