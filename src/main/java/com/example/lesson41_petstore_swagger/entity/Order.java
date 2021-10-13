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
public class Order {

    private long id;

    @NotBlank
    @NotEmpty
    @NotNull
    private long petId;

    @NotBlank
    @NotEmpty
    @NotNull
    private String shipDate;

    @NotBlank
    @NotEmpty
    @NotNull
    private StatusOrder status;

    private boolean complete;

}
