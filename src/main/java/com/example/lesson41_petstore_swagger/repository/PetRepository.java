package com.example.lesson41_petstore_swagger.repository;

import com.example.lesson41_petstore_swagger.entity.Pet;
import com.example.lesson41_petstore_swagger.entity.StatusPet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<List<Pet>> findByStatus(StatusPet status);

    Optional<Pet> findById(long id);
}
