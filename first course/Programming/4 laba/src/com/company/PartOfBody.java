package com.company;

public enum PartOfBody {
    HEAD("Голова"),
    BODY("Туловище"),
    LEGS("Ноги"),
    FEET("Ступни"),
    ARMS("Руки");
    private final String name;

    PartOfBody(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
