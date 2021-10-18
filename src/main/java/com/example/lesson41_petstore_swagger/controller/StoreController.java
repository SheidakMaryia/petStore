package com.example.lesson41_petstore_swagger.controller;

import com.example.lesson41_petstore_swagger.entity.Order;
import com.example.lesson41_petstore_swagger.entity.Pet;
import com.example.lesson41_petstore_swagger.service.StoreService;
import com.example.lesson41_petstore_swagger.service.serviceSpringDataJPA.StoreServiceSpringDataJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreServiceSpringDataJPA storeService;

    public StoreController(StoreServiceSpringDataJPA storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/order")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        if (storeService.addNewOrder(order)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable long id){
        Optional<Order> orderById = storeService.findOrderById(id);
        if (orderById.isPresent()) {
            return ResponseEntity.ok(orderById.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> allOrders = storeService.getAllOrders();
        if (allOrders.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.ok(allOrders);
        }
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
