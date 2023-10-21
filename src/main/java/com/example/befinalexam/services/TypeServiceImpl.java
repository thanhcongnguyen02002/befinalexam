package com.example.befinalexam.services;

import com.example.befinalexam.model.Type;
import com.example.befinalexam.repository.TypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TypeServiceImpl implements TypeService {

    TypeRepository repository;

    @Override
    public List<Type> getAll() {

        return  repository.findAll();
    }

    @Override
    public Type create(Type type) {

        if (!CollectionUtils.isEmpty(type.getProducts())) {
            type.getProducts()
                    .forEach(address -> address.setType(type));
        }


        return repository.save(type);
    }
}
