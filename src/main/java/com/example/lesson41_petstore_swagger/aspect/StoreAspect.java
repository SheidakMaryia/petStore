package com.example.lesson41_petstore_swagger.aspect;

import com.example.lesson41_petstore_swagger.entity.Order;
import com.example.lesson41_petstore_swagger.entity.Pet;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class StoreAspect {

    private final Logger logger = LoggerFactory.getLogger(StoreAspect.class.getName());

    @Pointcut("execution(public * com.example.lesson41_petstore_swagger.controller.StoreController.addOrder(..)) && args(order, ..))")
    public void addOrder(Order order){}

    @After(value = "addOrder(order)", argNames = "order")
    public void logAddOrder(Order order){
        logger.info("Order with id = {} added.", order.getId());
    }

    @Pointcut("execution(public * com.example.lesson41_petstore_swagger.controller.StoreController.findOrderById(..)) && args(id, ..))")
    public void findOrderById(long id){}

    @After(value = "findOrderById(id)", argNames = "id")
    public void logFindOrderById(long id){
        logger.info("Order with id = {} found.", id);
    }

    @Pointcut("execution(public * com.example.lesson41_petstore_swagger.controller.StoreController.getAllOrders(..))")
    public void getAllOrders(){}

    @After("getAllOrders()")
    public void logGetAllOrders(){
        logger.info("All orders found.");
    }

    @Pointcut("execution(public * com.example.lesson41_petstore_swagger.controller.StoreController.delete(..)) && args(id, ..))")
    public void delete(long id){}

    @After(value = "delete(id)", argNames = "id")
    public void logOfDelete(long id){
        logger.info("Order with id = {} deleted.", id);
    }
}
