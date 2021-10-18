package com.example.lesson41_petstore_swagger.controller;

import com.example.lesson41_petstore_swagger.dao.PetDao;
import com.example.lesson41_petstore_swagger.entity.Pet;
import com.example.lesson41_petstore_swagger.entity.StatusPet;
import com.example.lesson41_petstore_swagger.repository.PetRepository;
import com.example.lesson41_petstore_swagger.service.PetService;
import com.example.lesson41_petstore_swagger.service.serviceSpringDataJPA.PetServiceSpringDataJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetServiceSpringDataJPA petService;


    @PostMapping
    public ResponseEntity<Pet> addPet(@Valid @RequestBody Pet pet){
        if (petService.addPet(pet)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        }
    }

    @PutMapping
    public ResponseEntity<Pet> update(@Valid @RequestBody Pet pet){
        if (petService.updatePet(pet)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findByStatus")
    private ResponseEntity<List<Pet>> findByStatus(String statusPet){
        Optional<List<Pet>> byStatus = petService.findByStatus(statusPet);
        if (byStatus.isPresent()){
            return ResponseEntity.ok(byStatus.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Pet> findPetById(@PathVariable long id){
        Optional<Pet> byId = petService.findById(id);
        if (byId.isPresent()){
            return ResponseEntity.ok(byId.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/getAll")
    private ResponseEntity<List<Pet>> getAllPets(){
        List<Pet> all = petService.getAll();
        if (all.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(all);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Pet> delete(@PathVariable long id){
        if(petService.deleteById(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }












    //without Spring Data JPA
//    @Autowired
//    private final PetService petService;
//
//    public PetController(PetService petService) {
//        this.petService = petService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Pet> addPet(@Valid @RequestBody Pet pet){
//        if(petService.isExist(pet)){
//            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
//        }else{
//            petService.addPet(pet);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//    }
//
//    @PutMapping
//    public ResponseEntity<Pet> update(@Valid @RequestBody Pet pet){
//        if(petService.updatePet(pet)){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }else{
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//    }
//
//    @GetMapping("/findByStatus")
//    private ResponseEntity<List<Pet>> findByStatus(String statusPet){
//        List<Pet> pet = petService.findByStatus(statusPet);
//        if (pet != null){
//            return ResponseEntity.ok(pet);
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }
//
//    @GetMapping("/{id}")
//    private ResponseEntity<Pet> findPetById(@PathVariable long id){
//        return petService.findById(id);
//    }
//
//    @GetMapping("/getAll")
//    private ResponseEntity<List<Pet>> getAllPets(){
//        List<Pet> allPets = petService.getAll();
//        if (allPets.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }else {
//            return ResponseEntity.ok(allPets);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    private ResponseEntity<Pet> delete(@PathVariable long id){
//        if(petService.deleteById(id)){
//            return new ResponseEntity<>(HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
}
