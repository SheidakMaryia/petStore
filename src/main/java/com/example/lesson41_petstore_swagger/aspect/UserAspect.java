package com.example.lesson41_petstore_swagger.aspect;

import com.example.lesson41_petstore_swagger.entity.User;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Aspect
public class UserAspect {

    private final Logger logger = LoggerFactory.getLogger(UserAspect.class.getName());

    @Pointcut("execution(public * com.example.lesson41_petstore_swagger.controller.UserController.createUser(..)) && args(user, ..))")
    public void createUser(User user){}

    @After(value = "createUser(user)", argNames = "user")
    public void logOfCreateUser(User user){
        logger.info("Register new user - {}.", user.getUsername());
    }

    @Pointcut("execution(public * com.example.lesson41_petstore_swagger.controller.UserController.createWithList(..)) && args(users, ..))")
    public void addListOfUsers(List<User> users){}

    @After(value = "addListOfUsers(users)", argNames = "users")
    public void logOfListOfUsers(List<User> users){
        logger.info("Register {} new users.", users.size());
    }

    @Pointcut("execution(public * com.example.lesson41_petstore_swagger.controller.UserController.findByUsername(..)) && args(username, ..))")
    public void findByUsername(String  username){}

    @After(value = "findByUsername(username)", argNames = "username")
    public void logFindByUsername(String  username){
        logger.info("User {} found.", username);
    }

    @Pointcut("execution(public * com.example.lesson41_petstore_swagger.controller.UserController.findAllUsers(..))")
    public void findAllUsers(){}

    @After("findAllUsers()")
    public void logFindAllUsers(){
        logger.info("All users found.");
    }


    @Pointcut("execution(public * com.example.lesson41_petstore_swagger.controller.UserController.update(..)) && args(user, ..))")
    public void update(User user){}

    @After(value = "update(user)", argNames = "user")
    public void logOfUpdate(User user){
        logger.info("User {} updated.", user.getUsername());
    }


    @Pointcut("execution(public * com.example.lesson41_petstore_swagger.controller.UserController.delete(..)) && args(id, ..))")
    public void delete(long id){}

    @After(value = "delete(id)", argNames = "id")
    public void logOfDelete(long id){
        logger.info("User with id = {} deleted.", id);
    }

}
