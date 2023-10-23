package com.example.befinalexam.controller;

import com.example.befinalexam.model.Type;
import com.example.befinalexam.model.User;
import com.example.befinalexam.repository.UserRepository;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResp toUserResp(User user);
    User toUser(UserReq userReq);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(UserUpdateReq req, @MappingTarget User user);
}
