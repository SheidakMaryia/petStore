package com.example.lesson41_petstore_swagger.repository;

import com.example.lesson41_petstore_swagger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
