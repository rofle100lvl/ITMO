package com.company;

public class Feel {
    private String description;
    private Size size;
    private int good;//в процентах
    public Feel(String description, Size size,int good) {
        this.description = description;
        this.size = size;
        this.good = good;
    }

    public String getDescription() {
        return description;
    }

    public Size getSize() {
        return size;
    }

    public int getGood() {
        return good;
    }
}
