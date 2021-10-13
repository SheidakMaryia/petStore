package com.example.lesson41_petstore_swagger.dao;

import com.example.lesson41_petstore_swagger.entity.User;

import java.util.List;

public interface UserDao {
    void createWithList(List<User> users);

    void createUser(User user);

    User getUserByUsername(String username);

    void update(User user);

    void deleteUserById(long id);

    boolean isExist(User user);

    boolean isExistById(long id);

    List<User> getAllUsers();

}
