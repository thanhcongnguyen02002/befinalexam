package com.example.befinalexam.repository.postgres;

import com.example.befinalexam.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeJpaRepository extends JpaRepository<Type, Long> {
}
