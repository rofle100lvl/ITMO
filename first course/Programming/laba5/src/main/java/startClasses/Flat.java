package startClasses;

import annotations.*;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import startClasses.Coordinates;
import startClasses.Furnish;
import startClasses.House;
import utils.ZonedDateTimeAdapter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Начальный коасс квартир
 */

@XmlType(propOrder = {"name", "coordinates", "area", "numberOfRooms", "price", "balcony", "furnish", "house", "creationDate"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Flat implements Comparable<Flat>{
    @XmlTransient
    private static Long count = 0l;

    @XmlTransient
    @NotNull
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    @XmlElement
    @NotNull
    @NotEqualString
    private String name; //Поле не может быть null, Строка не может быть пустой

    @NotNull
    private Coordinates coordinates; //Поле не может быть null

    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    @XmlElement(name = "creationElementDate")
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    @GreaterThan(num=0)
    private float area; //Значение поля должно быть больше 0

    @NotNull
    @GreaterThan(num=0)
    private Long numberOfRooms; //Поле может быть null, Значение поля должно быть больше 0

    @Between(from=0,to=121887043)
    private Integer price; //Максимальное значение поля: 121887043, Значение поля должно быть больше 0

    @NotNull
    private Boolean balcony; //Поле может быть null

    @NotNull
    private Furnish furnish; //Поле может быть null

    @NotNull
    private House house; //Поле может быть null

    public Flat() {
        house = new House();
        coordinates = new Coordinates();
        numberOfRooms = new Long(0);
        creationDate = ZonedDateTime.now();
        id = count;
        count += 1;
    }

    public Flat(String name){
        this.name=name;
        creationDate=ZonedDateTime.now();
        id=count;
        count++;

    }
    @Getter
    public Integer getPrice() {
        return price;
    }

    @Getter
    public float getArea() {
        return area;
    }

    @Getter
    public String getName() {
        return name;
    }

    @Getter
    public Long getNumberOfRooms() {
        return numberOfRooms;
    }
    @Getter
    public Long getId() {
        return id;
    }

    @Getter
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Getter
    public Boolean getBalcony() {
        return balcony;
    }

    @Getter
    public Furnish getFurnish() {
        return furnish;
    }
    @Getter
    public House getHouse() {
        return house;
    }

    @Setter
    public void setId(Long id) {
        this.id = id;
    }

    @Setter
    public void setName(String name) {
        this.name = name;
    }

    @Setter
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Setter
    public void setCoordinates(float x, Float y) {
        coordinates.setX(x);
        coordinates.setY(y);
    }

    @Setter
    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
   }

    @Setter
    public void setArea(float area) {
        this.area = area;
    }

    @Setter
    public void setNumberOfRooms(Long numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Setter
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Setter
    public void setBalcony(Boolean balcony) {
        this.balcony = balcony;
    }

    @Setter
    public void setFurnish(Furnish furnish) {
        this.furnish = furnish;
    }

    @Setter
    public void setHouse(House house) {
        this.house = house;
    }

    @Setter
    public void setHouse(String name, Long year, Integer numberOfFloors, int numberOfFlatsOnFloor, Long numberOfLifts) {
        house.setName(name);
        house.setYear(year);
        house.setNumberOfFloors(numberOfFloors);
        house.setNumberOfFlatsOnFloor(numberOfFlatsOnFloor);
        house.setNumberOfLifts(numberOfLifts);
    }



    public boolean greaterThan(Flat b){
        if(price>b.getPrice())return true;
        return false;
    }

    public String niceToString() {
        return "\t\t\t\t\t\tКВАРТUРА " + id + "\n" +
                "Номер квартиры: " + id +
                ", имя собственника: " + name +
                ", координаты квартиры: (" + coordinates.getX() + ", " + coordinates.getY() + ")" +
                ",\n время добавления квартиры в коллекцию: " + creationDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ss")) +
                ",\n цена квартиры: " + price  +
                ", число комнат: " + numberOfRooms +
                ", площадь квартиры: " + area  + " кв.м." +
                ", наличие балкона: " + balcony +
                ", ремонт: " + furnish +
                ",\n данные дома {Название - " + house.getName() + ", год постройки - " + house.getYear() + ", число квартир на этаже - " + house.getNumberOfFlatsOnFloor() + "}";
    }

    @Override
    public String toString() {
        return "\t\t\t\t\t\tКВАРТUРА " + id + "\n";
    }

    @Override
    public int compareTo(Flat o) {
        return this.price-o.price;
    }
}
