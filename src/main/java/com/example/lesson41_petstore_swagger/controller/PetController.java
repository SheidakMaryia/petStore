package com.example.lesson41_petstore_swagger.controller;

import com.example.lesson41_petstore_swagger.dao.PetDao;
import com.example.lesson41_petstore_swagger.entity.Pet;
import com.example.lesson41_petstore_swagger.entity.StatusPet;
import com.example.lesson41_petstore_swagger.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<Pet> addPet(Pet pet){
        if(petService.isExist(pet)){
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        }else{
            petService.addPet(pet);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<Pet> update(Pet pet){
        if(petService.updatePet(pet)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/findByStatus")
    private ResponseEntity<List<Pet>> findByStatus(StatusPet statusPet){
        return petService.findByStatus(statusPet);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Pet> findPetById(@PathVariable long id){
        return petService.findById(id);
    }

    @GetMapping("/getAll")
    private ResponseEntity<List<Pet>> getAllPets(){
        List<Pet> allPets = petService.getAll();
        if (allPets.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.ok(allPets);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Pet> delete(@PathVariable long id){
        if(petService.deleteById(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
