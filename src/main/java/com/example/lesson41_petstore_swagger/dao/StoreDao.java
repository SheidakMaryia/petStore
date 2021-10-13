package com.example.lesson41_petstore_swagger.dao;

import com.example.lesson41_petstore_swagger.entity.Order;

import java.util.List;

public interface StoreDao {

    void addOrder(Order order);

    Order findOrderById(long id);

    void deleteOrderById(long id);

    boolean isExist(Order order);

    boolean isExistById(long id);

    List<Order> getAllOrders();
}
