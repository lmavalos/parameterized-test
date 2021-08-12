package com.lmavalos;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class FoodNotParametizedTest implements WithAssertions {

    @Test
    public void meatNotVegan() {
        assertThat(Food.MEAT.isVegan()).isFalse();
    }

    @Test
    public void fruitIsVegan() {
        assertThat(Food.FRUIT.isVegan()).isTrue();
    }

    @Test
    public void milkNotVegan() {
        assertThat(Food.MILK.isVegan()).isFalse();
    }

    @Test
    public void legumeIsVegan() {
        assertThat(Food.LEGUME.isVegan()).isTrue();
    }

    @Test
    public void bubbleGumNotVegan() {
        assertThat(Food.BUBBLE_GUM.isVegan()).isFalse();
    }

    @Test
    public void oreoIsVegan() {
        assertThat(Food.OREO.isVegan()).isTrue();
    }

}
