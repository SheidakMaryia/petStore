package com.example.lesson41_petstore_swagger.dao;

import com.example.lesson41_petstore_swagger.entity.Pet;
import com.example.lesson41_petstore_swagger.entity.StatusPet;
import com.example.lesson41_petstore_swagger.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetDaoImpl implements PetDao{
    private final List<Pet> petList = new ArrayList<>();

    @Override
    public void createPet(Pet pet) {
        petList.add(pet);
    }

    @Override
    public void update(Pet pet) {
        petList.set(petList.indexOf(pet), pet);
    }

    @Override
    public List<Pet> findByStatus(StatusPet statusPet) {
        return petList.stream().filter(x -> x.getStatus().equals(statusPet)).collect(Collectors.toList());
    }

    @Override
    public Pet findById(long id) {
        return petList.stream().filter(x -> x.getId() == id).findFirst().get();
    }

    @Override
    public void deleteById(long id) {
        Pet pet = petList.stream().filter(x -> x.getId() == id).findFirst().get();
        petList.remove(pet);
    }

    @Override
    public boolean isExist(Pet pet) {
        return petList.contains(pet);
    }

    @Override
    public boolean isExistById(long id) {
        return petList.stream().anyMatch(x -> x.getId() == id);
    }

    @Override
    public List<Pet> getAll() {
        return petList;
    }
}
