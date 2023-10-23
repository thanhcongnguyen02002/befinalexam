package com.example.befinalexam.services;

import com.example.befinalexam.model.ErrorException;
import com.example.befinalexam.model.Product;
import com.example.befinalexam.model.Type;
import com.example.befinalexam.repository.ErrorCode;
import com.example.befinalexam.repository.TypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TypeServiceImpl implements TypeService {
    TypeRepository repository;

    @Override
    public Page<Type> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    public  Type findbyId(Long id){
        return  repository.findById(id);
    }
    @Override
    public Type create(Type type) {
        if (!CollectionUtils.isEmpty(type.getProducts())) {
            type.getProducts()
                    .forEach(address -> address.setType(type));
        }
        return  repository.save(type);
    }
    @Override
    @Transactional
    public Type addProduct(Long id, Product product) {
        var type = findbyId(id);
        type.getProducts().add(product);
        product.setType(type);
        return  repository.save(type);
    }

    @Override
    public void deleteById(Long id) {
        var check = findbyId(id);
        if(check == null){
            throw  new ErrorException(ErrorCode.TYPE_NOT_FOUND,"type not found with id= "+id);
        }
        repository.deleteById(id);
    }

    @Override
    public Type update(Type type) {
        return repository.save(type);
    }
}
