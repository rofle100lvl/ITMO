package startClasses;

import annotations.GreaterThan;
import annotations.NotNull;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
public class House {
    @XmlElement
    @NotNull
    private String name; //Поле не может быть null
    @XmlElement
    @GreaterThan(num=0)
    private Long year; //Значение поля должно быть больше 0
    @XmlElement
    @NotNull
    @GreaterThan(num=0)
    private Integer numberOfFloors; //Поле не может быть null, Значение поля должно быть больше 0
    @XmlElement
    @GreaterThan(num=0)
    private int numberOfFlatsOnFloor; //Значение поля должно быть больше 0
    @XmlElement
    @GreaterThan(num=0)
    private Long numberOfLifts; //Значение поля должно быть больше 0

    public House() {
    }

    public House(String name, Long year, Integer numberOfFloors, int numberOfFlatsOnFloor, Long numberOfLifts) {
        this.name = name;
        this.year = year;
        this.numberOfFloors = numberOfFloors;
        this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
        this.numberOfLifts = numberOfLifts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getNumberOfFlatsOnFloor() {
        return numberOfFlatsOnFloor;
    }

    public void setNumberOfFlatsOnFloor(int numberOfFlatsOnFloor) {
        this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
    }

    public Long getNumberOfLifts() {
        return numberOfLifts;
    }

    public void setNumberOfLifts(Long numberOfLifts) {
        this.numberOfLifts = numberOfLifts;
    }
}