package com.example.befinalexam.services;

import com.example.befinalexam.controller.UserFillter;
import com.example.befinalexam.controller.UserReq;
import com.example.befinalexam.controller.UserResp;
import com.example.befinalexam.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Page<User> getAll(UserFillter fillter,Pageable pageable);
    User save(User user);
    User findById(Long id);
    void  deleteById(Long id);

    User update(User user);
}
