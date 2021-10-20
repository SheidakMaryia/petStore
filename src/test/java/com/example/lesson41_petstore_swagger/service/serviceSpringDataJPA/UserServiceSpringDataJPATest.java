package com.example.lesson41_petstore_swagger.service.serviceSpringDataJPA;

import com.example.lesson41_petstore_swagger.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class UserServiceSpringDataJPATest {

    private final UserServiceSpringDataJPA userService;
    private static final List<User> users = new ArrayList<>();

    @Autowired
    UserServiceSpringDataJPATest(UserServiceSpringDataJPA userService) {
        this.userService = userService;
    }

    @BeforeAll
    void initializationOfUsers(){
        users.add(User.builder()
                .id(1)
                .username("masha")
                .firstName("Masha")
                .lastName("Shei")
                .email("masha@mail.ru")
                .password("111")
                .phone("111")
                .userStatus(1)
                .build());
        users.add(User.builder()
                .id(2)
                .username("sasha")
                .firstName("Sasha")
                .lastName("Sasha")
                .email("sasha@mail.ru")
                .password("22")
                .phone("22")
                .userStatus(1)
                .build());
    }

    @Test
    void addUser_and_findUserByUsername_test() {
        userService.addUser(users.get(0));
        Assertions.assertEquals(users.get(0), userService.findUserByUsername(users.get(0).getUsername()).get());
    }

    @Test
    void addListOfUsers_and_getAllUsers_test() {
        userService.addUser(users.get(0));
        userService.addUser(users.get(1));

        Assertions.assertEquals(users.size(), userService.getAllUsers().size());
    }


    @Test
    void updateUser() {
        User updatedUser = new User(1, "newMasha", "newMasha", "newMasha", "newmasha@mail.ru", "new111", "newTel111", 1);
        userService.updateUser(updatedUser);

        //org.assertj.core.api.Assertions.assertThat(users.get(0).getUsername(), )

        Assertions.assertNotEquals(users.get(0), userService.findUserByUsername(updatedUser.getUsername()));
    }

    @Test
    void deleteUserById() {
        userService.addUser(users.get(0));
        userService.addUser(users.get(1));

        userService.deleteUserById(1);

        Assertions.assertEquals(1, userService.getAllUsers().size());
    }

}