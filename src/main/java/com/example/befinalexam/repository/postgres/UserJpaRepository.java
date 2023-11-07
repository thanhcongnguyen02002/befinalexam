package com.example.befinalexam.repository.postgres;

import com.example.befinalexam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserJpaRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
}
