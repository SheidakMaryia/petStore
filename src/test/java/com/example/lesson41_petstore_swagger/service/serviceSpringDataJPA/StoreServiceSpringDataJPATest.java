package com.example.lesson41_petstore_swagger.service.serviceSpringDataJPA;

import com.example.lesson41_petstore_swagger.entity.Order;
import com.example.lesson41_petstore_swagger.entity.StatusOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class StoreServiceSpringDataJPATest {

    private final StoreServiceSpringDataJPA storeService;
    private static final List<Order> orders = new ArrayList<>();

    @Autowired
    StoreServiceSpringDataJPATest(StoreServiceSpringDataJPA storeService) {
        this.storeService = storeService;
    }

    @BeforeAll
    void initializationOfOrders(){
        orders.add(Order.builder()
                .id(1)
                .petId(1)
                .shipDate(LocalDateTime.now())
                .status(StatusOrder.approved)
                .complete(true)
                .build());
        orders.add(Order.builder()
                .id(2)
                .petId(2)
                .shipDate(LocalDateTime.now())
                .status(StatusOrder.placed)
                .complete(false)
                .build());
        orders.add(Order.builder()
                .id(3)
                .petId(3)
                .shipDate(LocalDateTime.now())
                .status(StatusOrder.delivered)
                .complete(true)
                .build());
        orders.add(Order.builder()
                .id(4)
                .petId(4)
                .shipDate(LocalDateTime.now())
                .status(StatusOrder.approved)
                .complete(true)
                .build());
    }

    @Test
    void addNewOrder_and_findOrderById() {
        storeService.addNewOrder(orders.get(0));

        Assertions.assertEquals(orders.get(0), storeService.findOrderById(orders.get(0).getId()).get());
    }

    @Test
    void getAllOrders() {
        storeService.addNewOrder(orders.get(0));
        storeService.addNewOrder(orders.get(1));

        Assertions.assertEquals(2, storeService.getAllOrders().size());
    }

    @Test
    void deleteOrderById() {
        storeService.addNewOrder(orders.get(0));
        storeService.addNewOrder(orders.get(1));

        storeService.deleteOrderById(1);

        Assertions.assertEquals(1, storeService.getAllOrders().size());

    }
}