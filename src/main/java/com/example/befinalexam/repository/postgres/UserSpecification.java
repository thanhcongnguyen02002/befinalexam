package com.example.befinalexam.repository.postgres;

import com.example.befinalexam.controller.UserFillter;

import com.example.befinalexam.model.User;
import org.springframework.data.jpa.domain.Specification;

public final class UserSpecification {
    public  static Specification<User> withFillter(UserFillter fillter){
        return Specification.where(withName(fillter.username()));
    }

    private static Specification<User> withName(String username) {
        if(username== null){
            return  null;
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("username"),"%" +username+"%");
    }
}
