package com.example.befinalexam.repository;

import com.example.befinalexam.controller.UserFillter;
import com.example.befinalexam.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
 Page<User> findAll(UserFillter fillter,Pageable pageable);
 User save(User user);
 Optional<User> findById(Long id);
 void delete(Long id);
}
