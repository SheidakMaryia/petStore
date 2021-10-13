package com.example.lesson41_petstore_swagger.dao;

import com.example.lesson41_petstore_swagger.entity.Order;
import com.example.lesson41_petstore_swagger.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreDaoImpl implements StoreDao{
    private final List<Order> orderList = new ArrayList<>();

    @Override
    public void addOrder(Order order) {
        orderList.add(order);
    }

    @Override
    public Order findOrderById(long id) {
        return orderList.stream().filter(x -> x.getId() == id).findFirst().get();
    }

    @Override
    public void deleteOrderById(long id) {
        orderList.removeIf(x -> x.getId() == id);
    }

    @Override
    public boolean isExist(Order order) {
        return orderList.contains(order);
    }

    @Override
    public boolean isExistById(long id) {
        return orderList.stream().anyMatch(x -> x.getId() == id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderList;
    }
}
