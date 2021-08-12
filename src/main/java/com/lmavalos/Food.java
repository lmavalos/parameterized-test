package com.lmavalos;

public enum Food {

    MEAT("MEAT", false),
    FRUIT("FRUIT", true),
    MILK("MILK", false),
    LEGUME("LEGUME", true),
    BUBBLE_GUM("BUBBLE_GUM", false),
    OREO("OREO", true);

    private final String name;
    private final boolean vegan;

    Food(String name, boolean isVegan) {
        this.name = name;
        this.vegan = isVegan;
    }

    public String getName() {
        return name;
    }

    public boolean isVegan() {
        return vegan;
    }

    @Override
    public String toString() {
        return name;
    }
}
