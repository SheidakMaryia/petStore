package com.example.lesson41_petstore_swagger.service.serviceSpringDataJPA;

import com.example.lesson41_petstore_swagger.dao.UserDao;
import com.example.lesson41_petstore_swagger.entity.User;
import com.example.lesson41_petstore_swagger.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceSpringDataJPA {

    private UserRepository userRepository;

    public UserServiceSpringDataJPA(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean addUser(User user){
        if (userRepository.existsById(user.getId())){
            return false;
        }
        userRepository.save(user);
        return true;
    }

    public boolean addListOfUsers(List<User> users){
        if (users.isEmpty()){
            return false;
        }
        userRepository.saveAll(users);
        return true;
    }

    public Optional<User> findUserByUsername(String username){
        Optional<User> byUsername = userRepository.findByUsername(username);
        return byUsername;
    }

    public boolean updateUser(User user){
        if (userRepository.existsById(user.getId())){
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean deleteUserById(long id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
