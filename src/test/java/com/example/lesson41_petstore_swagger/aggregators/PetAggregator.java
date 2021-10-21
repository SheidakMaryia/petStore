package com.example.lesson41_petstore_swagger.aggregators;

import com.example.lesson41_petstore_swagger.entity.Pet;
import com.example.lesson41_petstore_swagger.entity.StatusPet;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class PetAggregator implements ArgumentsAggregator {
    @Override
    public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
        return Pet.builder()
                .id(argumentsAccessor.getLong(0))
                .name(argumentsAccessor.getString(1))
                .status(StatusPet.valueOf(argumentsAccessor.getString(2)))
                .build();
    }
}
