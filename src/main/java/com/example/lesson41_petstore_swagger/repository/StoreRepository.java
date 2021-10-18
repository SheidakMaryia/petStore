package com.example.lesson41_petstore_swagger.repository;

import com.example.lesson41_petstore_swagger.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Order, Long> {
}
