package com.example.befinalexam.services;

import com.example.befinalexam.controller.UserReq;
import com.example.befinalexam.controller.UserResp;
import com.example.befinalexam.model.User;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    User save(User user);
    User findById(Long id);
    void  deleteById(Long id);

    User update(User user);
}
