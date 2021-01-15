package com.company;

abstract public class Wear {
    private String name;
    private PartOfBody partOfBody;

    public Wear(String name, PartOfBody location) {
        this.name = name;
        partOfBody= location;
    }

    public String getName() {
        return name;
    }

    public PartOfBody getLocation() {
        return partOfBody;
    }
}
