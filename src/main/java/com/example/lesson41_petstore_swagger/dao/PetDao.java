package com.example.lesson41_petstore_swagger.dao;

import com.example.lesson41_petstore_swagger.entity.Pet;
import com.example.lesson41_petstore_swagger.entity.StatusPet;
import com.example.lesson41_petstore_swagger.entity.User;

import java.util.List;

public interface PetDao {

    void createPet(Pet pet);

    void update(Pet pet);

    List<Pet> findByStatus(StatusPet statusPet);

    Pet findById(long id);

    void deleteById(long id);

    boolean isExist(Pet pet);

    boolean isExistById(long id);

    List<Pet> getAll();
}
