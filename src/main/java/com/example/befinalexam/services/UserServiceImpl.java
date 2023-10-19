package com.example.befinalexam.services;

import com.example.befinalexam.model.User;
import com.example.befinalexam.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional findById(Long id) {

        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.delete(id);
    }


}

