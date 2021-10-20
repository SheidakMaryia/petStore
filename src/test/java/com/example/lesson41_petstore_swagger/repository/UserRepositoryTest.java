package com.example.lesson41_petstore_swagger.repository;

import com.example.lesson41_petstore_swagger.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Autowired
    UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    void findByUsername() {
        User user = User.builder()
                .id(1)
                .username("masha")
                .firstName("Masha")
                .lastName("Shei")
                .email("masha@mail.ru")
                .password("111")
                .phone("111")
                .userStatus(1)
                .build();
        userRepository.save(user);
        Assertions.assertEquals(user.getUsername(), userRepository.findByUsername("masha").get().getUsername());
    }
}