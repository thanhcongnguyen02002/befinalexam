package com.example.befinalexam.repository.postgres;

import com.example.befinalexam.model.Type;
import com.example.befinalexam.repository.TypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
@Primary
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TypeRepositoryImpl implements TypeRepository {
    TypeJpaRepository jpaRepository;

    @Override
    public List<Type> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Type save(Type type) {
        return jpaRepository.save(type);
    }
}
