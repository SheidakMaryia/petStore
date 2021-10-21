package com.example.lesson41_petstore_swagger.service.serviceSpringDataJPA;

import com.example.lesson41_petstore_swagger.aggregators.PetAggregator;
import com.example.lesson41_petstore_swagger.entity.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class PetServiceSpringDataJPATest {

    private final PetServiceSpringDataJPA petService;
    private static final List<Pet> pets = new ArrayList<>();

    @Autowired
    PetServiceSpringDataJPATest(PetServiceSpringDataJPA petService) {
        this.petService = petService;
    }


    @BeforeAll
    void initializationOfPets(){
        Pet pet1 = Pet.builder()
                .id(1)
                .category(Category.builder()
                        .name("dog").build())
                .name("Toddy")
                .tag(List.of(Tag.builder()
                            .name("123")
                            .build(),
                        Tag.builder()
                                .name("456")
                                .build()))
                .status(StatusPet.available)
                .build();
        Pet pet2 = Pet.builder()
                .id(2)
                .category(Category.builder()
                        .name("dog").build())
                .name("Nort")
                .tag(List.of(Tag.builder()
                            .name("1234")
                            .build(),
                        Tag.builder()
                                .name("4456")
                                .build()))
                .status(StatusPet.sold)
                .build();
        petService.addPet(pet1);
        petService.addPet(pet2);
    }

    @ParameterizedTest
    @CsvSource({"1, Toddy, available",
                "2, Nort, sold"
    })
    @DisplayName("addPet")
    void addPet(@AggregateWith(PetAggregator.class) Pet pet) {
        petService.addPet(pet);

        assertEquals(2, petService.getAll().size());//expected, actual
    }

    @ParameterizedTest
    @CsvSource({"1, Toddy, available"})
    @DisplayName("findById")
    void findById(@AggregateWith(PetAggregator.class) Pet pet) {
        Optional<Pet> byId = petService.findById(pet.getId());

        assertEquals(pet, byId.get());
    }

    @ParameterizedTest
    @CsvSource({"1, Toddy, available"})
    @DisplayName("updatePet")
    void updatePet(@AggregateWith(PetAggregator.class) Pet pet) {
        petService.updatePet(pet);
        assertEquals(pet, petService.findByStatus(pet.getStatus().toString()).get().get(0));
    }

    @ParameterizedTest
    @CsvSource({"1, Toddy, available"})
    @DisplayName("findByStatus")
    void findByStatus(@AggregateWith(PetAggregator.class) Pet pet) {
        assertEquals(pet, petService.findByStatus(pet.getStatus().toString()).get().get(0));
    }


    @Test
    void getAll() {
        assertEquals(2, petService.getAll().size());
    }

    @ParameterizedTest
    @CsvSource({"1, Toddy, available"})
    @DisplayName("deleteById")
    void deleteById(@AggregateWith(PetAggregator.class) Pet pet) {
        petService.deleteById(pet.getId());
        assertEquals(1, petService.getAll().size());
    }





    //without parametrized test
//
//    @BeforeAll
//    void initializationOfPets(){
//        pets.add(Pet.builder()
//                .id(1)
//                .category(Category.builder()
//                        .name("dog").build())
//                .name("Toddy")
//                .tag(List.of(Tag.builder()
//                            .name("123")
//                            .build(),
//                        Tag.builder()
//                                .name("456")
//                                .build()))
//                .status(StatusPet.available)
//                .build());
//        pets.add(Pet.builder()
//                .id(2)
//                .category(Category.builder()
//                        .name("dog").build())
//                .name("Nort")
//                .tag(List.of(Tag.builder()
//                            .name("1234")
//                            .build(),
//                        Tag.builder()
//                                .name("4456")
//                                .build()))
//                .status(StatusPet.sold)
//                .build());
//
//    }
//
//
//    @Test
//    void addPet_and_findById() {
//        petService.addPet(pets.get(0));
//
//        assertEquals(pets.get(0), petService.findById(pets.get(0).getId()).get());
//    }
//
//    @Test
//    void updatePet() {
//        Tag tag1 = new Tag(1, "123");
//        Tag tag2 = new Tag(2, "456");
//        List<Tag> tags = new ArrayList<>();
//        tags.add(0, tag1);
//        tags.add(1, tag2);
//
//        Pet updatedPet = new Pet(1, new Category(1, "dog"), "newDog", tags, StatusPet.available);
//
//        petService.updatePet(updatedPet);
//        assertNotEquals(pets.get(0), petService.findById(updatedPet.getId()));
//    }
//
//    @Test
//    void findByStatus() {
//        petService.addPet(pets.get(0));
//
//        assertEquals(pets.get(0), petService.findByStatus("available").get().get(0));
//    }
//
//
//    @Test
//    void getAll() {
//        petService.addPet(pets.get(0));
//        petService.addPet(pets.get(1));
//
//        assertEquals(2, petService.getAll().size());
//    }
//
//    @Test
//    void deleteById() {
//        petService.addPet(pets.get(0));
//        petService.addPet(pets.get(1));
//
//        petService.deleteById(pets.get(0).getId());
//
//        assertEquals(1, petService.getAll().size());
//    }
}