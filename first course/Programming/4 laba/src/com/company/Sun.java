package com.company;

import java.util.Objects;

public class Sun {
    private double brightness;//в Люменах
    static class Ray{
        double length;//в миллиметрах

        public Ray(double length) {
            this.length = length;
        }
        public void rayShine(Being a){
            System.out.printf("Луч солнца светит на %s и прогревает его\n",a.getName());
        }
    }
    public Sun(double brightness) {
        this.brightness = brightness;
    }
    public void shine(Being a){
        for(int i=0;i<3;i++) {
            Ray ray=new Ray(1);
            ray.rayShine(a);
        }

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sun sun = (Sun) o;
        return Double.compare(sun.brightness, brightness) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brightness);
    }

}
