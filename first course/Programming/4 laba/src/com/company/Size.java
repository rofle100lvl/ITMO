package com.company;

public enum Size {
    VERYVERYHARD("Огромное-преогромное"),
    HARD("Сильное"),
    MEDIUM("Среднее"),
    LOW("Слабое");
    private String name;

    Size(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
