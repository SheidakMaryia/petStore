package com.example.lesson41_petstore_swagger.service;

import com.example.lesson41_petstore_swagger.dao.StoreDao;
import com.example.lesson41_petstore_swagger.entity.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private StoreDao storeDao;

    public StoreService(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    public void createNewOrder(Order order){
        storeDao.addOrder(order);
    }


    public ResponseEntity<Order> findOrderById(long id){
        Order orderById = storeDao.findOrderById(id);
        if (orderById != null){
            return ResponseEntity.ok(orderById);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    public List<Order> getAllOrders(){
        return storeDao.getAllOrders();
    }

    public boolean deleteOrderById(long id){
        if (storeDao.isExistById(id)){
            storeDao.deleteOrderById(id);
            return true;
        }else {
            return false;
        }
    }
}
