package com.example.lesson41_petstore_swagger.service;

import com.example.lesson41_petstore_swagger.dao.PetDao;
import com.example.lesson41_petstore_swagger.entity.Pet;
import com.example.lesson41_petstore_swagger.entity.StatusPet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private PetDao petDao;

    public PetService(PetDao petDao) {
        this.petDao = petDao;
    }

    public boolean addPet(Pet pet){
        if (petDao.isExist(pet)){
            return false;
        }else{
            petDao.createPet(pet);
            return true;
        }
    }

    public boolean updatePet(Pet pet){
        if (petDao.isExist(pet)){
            petDao.update(pet);
            return true;
        }else {
            return false;
        }
    }

    public List<Pet> findByStatus(String statusPet){
        return petDao.findByStatus(statusPet);
    }

    public ResponseEntity<Pet> findById(long id){
        Pet pet = petDao.findById(id);
        if (pet != null){
            return ResponseEntity.ok(pet);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    public List<Pet> getAll(){
        return petDao.getAll();
    }

    public boolean deleteById(long id) {
        if (petDao.isExistById(id)){
            petDao.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    public boolean isExist(Pet pet){
        return petDao.isExist(pet);
    }

}
