package com.company;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Wear{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wear wear = (Wear) o;
        return Objects.equals(name, wear.name) &&
                partOfBody == wear.partOfBody;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, partOfBody);
    }
}
