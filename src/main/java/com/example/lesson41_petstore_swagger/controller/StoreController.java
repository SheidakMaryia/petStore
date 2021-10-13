package com.example.lesson41_petstore_swagger.controller;

import com.example.lesson41_petstore_swagger.entity.Order;
import com.example.lesson41_petstore_swagger.entity.Pet;
import com.example.lesson41_petstore_swagger.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/order")
    public void makeOrder(Order order){
        storeService.createNewOrder(order);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable long id){
        return storeService.findOrderById(id);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Order> delete(@PathVariable long id){
        if (storeService.deleteOrderById(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
