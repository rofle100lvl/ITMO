package com.company;

public enum Volume {
    WHISPER("Шёпотом"),
    SAYLOUDLY("Громко"),
    SAYMEDIUMVOLUME("Средней громкостью");
    private String name;

    Volume(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
