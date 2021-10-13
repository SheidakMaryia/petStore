package com.example.lesson41_petstore_swagger.dao;

import com.example.lesson41_petstore_swagger.entity.Order;
import com.example.lesson41_petstore_swagger.entity.User;

public interface StoreDao {

    void order(Order order);

    Order findOrderById(long id);

    void deleteOrderById(long id);

    boolean isExist(Order order);

    boolean isExistById(long id);
}
