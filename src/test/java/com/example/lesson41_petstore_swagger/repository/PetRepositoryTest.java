package com.example.lesson41_petstore_swagger.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class PetRepositoryTest {

    private final PetRepository petRepository;

    @Autowired
    PetRepositoryTest(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Test
    void findByStatus() {

    }

    @Test
    void findById() {
    }
}