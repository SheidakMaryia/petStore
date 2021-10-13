package com.example.lesson41_petstore_swagger.dao;

import com.example.lesson41_petstore_swagger.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class UserDaoImpl implements UserDao{
    private final List<User> userList = new ArrayList<>();

    @Override
    public void createWithList(List<User> users) {
        for (User user : users) {
            if (!userList.contains(user)){
                userList.add(user);
            }
        }
    }

    @Override
    public void createUser(User user) {
        userList.add(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userList.stream().filter(x -> x.getUsername().equals(username)).findFirst().get();
    }

    @Override
    public void update(User user) {
        userList.set(userList.indexOf(user), user);
    }

    @Override
    public void deleteUserById(long id) {
        userList.removeIf(x -> x.getId() == id);
    }

    @Override
    public boolean isExist(User user) {
        return userList.contains(user);
    }

    @Override
    public boolean isExistById(long id) {
        return userList.stream().anyMatch(x -> x.getId() == id);
    }

}
