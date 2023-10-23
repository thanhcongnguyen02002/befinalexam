package com.example.befinalexam.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.control.MappingControl;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;
import java.util.function.Function;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "`user`")
@Builder
@Getter
@Setter
@ToString
@Slf4j
@RequiredArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    Long id;
    String username;
    String password;
    String email;
    @Enumerated(EnumType.STRING)
    Role role;
    public <R> R transform(Function<? super User, ? extends R> func) {
        Objects.requireNonNull(func);
        return func.apply(this);
    }

}
