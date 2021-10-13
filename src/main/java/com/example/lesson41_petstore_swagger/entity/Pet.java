package com.example.lesson41_petstore_swagger.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Pet {
    private long id;

    @NotBlank
    @NotEmpty
    @NotNull
    private Category category;

    @NotBlank
    @NotEmpty
    @NotNull
    private String name;
    private Tag tag;
    private StatusPet status;
}
