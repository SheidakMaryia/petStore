package com.example.lesson41_petstore_swagger.service.serviceSpringDataJPA;

import com.example.lesson41_petstore_swagger.entity.Pet;
import com.example.lesson41_petstore_swagger.entity.StatusPet;
import com.example.lesson41_petstore_swagger.repository.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceSpringDataJPA {

    private PetRepository petRepository;

    public PetServiceSpringDataJPA(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public boolean addPet(Pet pet){
        if (petRepository.existsById(pet.getId())){
            return false;
        }else{
            petRepository.save(pet);
            return true;
        }
    }

    public boolean updatePet(Pet pet){
        if (petRepository.existsById(pet.getId())){
            petRepository.save(pet);
            return true;
        }else {
            return false;
        }
    }

    public Optional<List<Pet>> findByStatus(String statusPet){
        return petRepository.findByStatus(StatusPet.valueOf(statusPet));
    }

    public Optional<Pet> findById(long id){
        return petRepository.findById(id);
    }

    public List<Pet> getAll(){
        return petRepository.findAll();
    }

    public boolean deleteById(long id) {
        if (petRepository.existsById(id)){
            petRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
