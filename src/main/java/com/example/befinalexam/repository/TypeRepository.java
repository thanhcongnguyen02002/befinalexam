package com.example.befinalexam.repository;

import com.example.befinalexam.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TypeRepository {
    Page<Type> findAll(Pageable pageable);
    Type save(Type type);
    Type findById(Long id);

    void deleteById(Long id);
}
