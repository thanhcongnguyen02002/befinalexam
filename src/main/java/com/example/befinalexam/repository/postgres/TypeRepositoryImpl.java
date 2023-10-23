package com.example.befinalexam.repository.postgres;

import com.example.befinalexam.model.ErrorException;
import com.example.befinalexam.model.Product;
import com.example.befinalexam.model.Type;
import com.example.befinalexam.repository.ErrorCode;
import com.example.befinalexam.repository.TypeRepository;
import com.sun.jdi.LongType;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Type> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable);
    }
    @Override
    public Type save( Type type) {

        return jpaRepository.save(type);
    }
    @Override
    public Type findById(Long id) {
        return jpaRepository.findById(id).orElseThrow(
                ()->new ErrorException(ErrorCode.TYPE_NOT_FOUND,"Type not found "+id)
        );
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
