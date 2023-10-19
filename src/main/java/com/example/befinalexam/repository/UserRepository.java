package com.example.befinalexam.repository;

import com.example.befinalexam.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
 List<User> findAll();
 User save(User user);
 Optional findById(Long id);
 void delete(Long id);
}
