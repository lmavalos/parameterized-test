package com.lmavalos.utils;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumbersUtilsTest implements WithAssertions {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void isOdd(int number) {
        assertThat(NumbersUtils.isOdd(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, -10, 50, Integer.MIN_VALUE})
    void isEven(int number) {
        assertThat(NumbersUtils.isEven(number)).isTrue();
    }
}
