package com.example.lesson41_petstore_swagger.service;

import com.example.lesson41_petstore_swagger.dao.UserDao;
import com.example.lesson41_petstore_swagger.entity.Pet;
import com.example.lesson41_petstore_swagger.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean addUser(User user){
        if (userDao.isExist(user)){
            return false;
        }else{
            userDao.createUser(user);
            return true;
        }
    }

    public void addListOfUsers(List<User> users){
        userDao.createWithList(users);
    }

    public ResponseEntity<User> findUserByUsername(String username){
        User userByUsername = userDao.getUserByUsername(username);
        if (userByUsername != null){
            return ResponseEntity.ok(userByUsername);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public boolean updateUser(User user){
        if (userDao.isExist(user)){
            return false;
        }else{
            userDao.update(user);
            return true;
        }
    }

    public boolean deleteUserById(long id){
        if (userDao.isExistById(id)){
            return false;
        }else{
            userDao.deleteUserById(id);
            return true;
        }
    }
}
