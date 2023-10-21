package com.example.befinalexam.config;

import com.example.befinalexam.repository.ProductRepository;
import com.example.befinalexam.repository.TypeRepository;
import com.example.befinalexam.repository.UserRepository;
import com.example.befinalexam.repository.postgres.UserJpaRepository;
import com.example.befinalexam.repository.postgres.UserRepositoryImpl;
import com.example.befinalexam.services.*;
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
    @Primary
    UserRepository repository(UserJpaRepository repository){
        return  new UserRepositoryImpl(repository);
    }
    @Bean
    DateTimeProvider provider() {
        return () -> Optional.of(OffsetDateTime.now());
    }
    @Bean
    TypeService typeService(TypeRepository repository)
    {
        return  new TypeServiceImpl(repository);
    }

    @Bean
    ProductService productService(ProductRepository repository)
    {
        return  new ProductServiceImpl(repository);
    }
}
