package com.example.lesson41_petstore_swagger.service.serviceSpringDataJPA;

import com.example.lesson41_petstore_swagger.dao.StoreDao;
import com.example.lesson41_petstore_swagger.entity.Order;
import com.example.lesson41_petstore_swagger.repository.StoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceSpringDataJPA {

    private StoreRepository storeRepository;

    public StoreServiceSpringDataJPA(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public boolean addNewOrder(Order order){
        if (storeRepository.existsById(order.getId())){
            return false;
        }
        storeRepository.save(order);
        return true;
    }

    public Optional<Order> findOrderById(long id){
        return storeRepository.findById(id);
    }

    public List<Order> getAllOrders(){
        return storeRepository.findAll();
    }

    public boolean deleteOrderById(long id){
        if (storeRepository.existsById(id)){
            storeRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
