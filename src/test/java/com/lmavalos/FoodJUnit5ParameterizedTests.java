package com.lmavalos;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class FoodJUnit5ParameterizedTests implements WithAssertions {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                arguments("OREO", true),
                arguments("BUBBLE_GUM", false),
                arguments("LEGUME", true),
                arguments("MILK", false),
                arguments("FRUIT", true),
                arguments("MEAT", false)
        );
    }

    private static Stream<Arguments> recognizeWhichFoodsAreVeganUsingDefaultMethod() {
        return parameters();
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void recognizeWhichFoodsAreVeganUsingMethod(Food food, boolean isVegan) {
        assertThat(food.isVegan()).isEqualTo(isVegan);
    }

    @ParameterizedTest
    @MethodSource
    void recognizeWhichFoodsAreVeganUsingDefaultMethod(Food food, boolean isVegan) {
        assertThat(food.isVegan()).isEqualTo(isVegan);
    }

    @ParameterizedTest
    @CsvSource({
            "OREO, true",
            "BUBBLE_GUM, false",
            "LEGUME, true",
            "MILK, false",
            "FRUIT, true",
            "MEAT, false"
    })
    void recognizeWhichFoodsAreVeganUsingFormatCsv(Food food, boolean isVegan) {
        assertThat(food.isVegan()).isEqualTo(isVegan);
    }

    @ParameterizedTest
    @CsvSource({
            "OREO, true",
            "BUBBLE_GUM, false",
            "LEGUME, true",
            "MILK, false",
            "FRUIT, true",
            "MEAT, false"
    })
    void recognizeWhichFoodsAreVeganWithArgumentAccessor(ArgumentsAccessor accessor) {
        final Food food = Food.valueOf(accessor.getString(0));
        final boolean isVegan = accessor.getBoolean(1);
        assertThat(food.isVegan()).isEqualTo(isVegan);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "OREO",
            "LEGUME",
            "FRUIT",
    })
    void recognizeWhichFoodsAreVeganUsingConverter(@ConvertWith(VeganFoodConverter.class) Food food) {
        assertThat(food.isVegan()).isTrue();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/food.csv")
    void recognizeWhichFoodsAreVeganUsingFromCsvFile(Food food, boolean isVegan) {
        assertThat(food.isVegan()).isEqualTo(isVegan);
    }

    static class VeganFoodConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) {
            for (Food food : Food.values()) {
                if (food.toString().equals(source.toString())) {
                    if (food.isVegan()) {
                        return food;
                    }
                }
            }
            return null;
        }
    }
}
