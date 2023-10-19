package com.example.befinalexam.config;

import com.example.befinalexam.repository.UserRepository;
import com.example.befinalexam.repository.postgres.UserJpaRepository;
import com.example.befinalexam.repository.postgres.UserRepositoryImpl;
import com.example.befinalexam.services.UserService;
import com.example.befinalexam.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.auditing.DateTimeProvider;

import java.time.OffsetDateTime;
import java.util.Optional;


@Configuration

public class AppConfig {
    @Bean
    UserService userService(UserRepository repository)
    {
        return  new UserServiceImpl(repository);
    }
    @Bean
    UserRepository repository(UserJpaRepository repository){
        return  new UserRepositoryImpl(repository);
    }
    @Bean
    DateTimeProvider provider() {
        return () -> Optional.of(OffsetDateTime.now());
    }
}
