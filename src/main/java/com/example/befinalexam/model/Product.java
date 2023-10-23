package com.example.befinalexam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;
import java.util.function.Function;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table
@Builder
@Getter
@Setter
@ToString
@Slf4j
@RequiredArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String productname;
    String description;
    double price;
    String image;
    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    @JsonIgnoreProperties("products")
    Type type;
    public <R> R transform(Function<? super Product, ? extends R> func) {
        Objects.requireNonNull(func);
        return func.apply(this);
    }
}
