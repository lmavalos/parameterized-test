package com.lmavalos;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class FoodJUnit4ParameterizedTests implements WithAssertions {

    private final Food food;
    private final boolean isVegan;

    public FoodJUnit4ParameterizedTests(Food food, boolean isVegan) {
        this.food = food;
        this.isVegan = isVegan;
    }

    /**
     * {index} es el indice del parametro actual
     * {0}     es el 1er parametro
     * {1}     es el 2do parametro
     */
    @Parameterized.Parameters(name = "#{index} | Food {0} is vegan? {1}")
    public static List<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {Food.MEAT, false},
                {Food.FRUIT, true},
                {Food.MILK, false},
                {Food.LEGUME, true},
                {Food.BUBBLE_GUM, false},
                {Food.OREO, true}
        });
    }

    @Test
    public void recognizeWhichFoodsAreVegan() {
        assertThat(food.isVegan()).isEqualTo(isVegan);
    }
}
