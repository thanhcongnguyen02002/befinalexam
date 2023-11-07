package com.example.befinalexam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;
import java.util.function.Function;

//@Entity
//@EntityListeners(AuditingEntityListener.class)
//@Table
//@Builder
//@Getter
//@Setter
//@ToString
//@Slf4j
//@RequiredArgsConstructor
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductType {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Double price;
    Long id;
    Long type_id;
    String description;
    String image;
    String productname;
    String name;
}
