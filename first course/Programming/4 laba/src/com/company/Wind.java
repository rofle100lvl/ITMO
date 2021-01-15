package com.company;

public class Wind {
    private double power;

    public Wind(double power) {
        this.power = power;
    }
    public void flowWind(Being a){
        System.out.printf("Ветер подул на %s\n",a.getName());
    }
}
