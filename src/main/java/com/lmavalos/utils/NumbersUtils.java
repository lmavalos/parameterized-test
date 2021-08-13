package com.lmavalos.utils;

public final class NumbersUtils {

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static boolean isEven(int number) {
        return !isOdd(number);
    }
}
