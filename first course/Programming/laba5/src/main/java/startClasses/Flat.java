package startClasses;

import annotations.Between;
import annotations.GreaterThan;
import annotations.NotNull;
import annotations.ShorterThan;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import startClasses.Coordinates;
import startClasses.Furnish;
import startClasses.House;
import utils.ZonedDateTimeAdapter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(propOrder = {"name", "coordinates", "area", "numberOfRooms", "price", "balcony", "furnish", "house","creationDate"})
@XmlAccessorType(XmlAccessType.FIELD)


public class Flat implements Comparable<Flat>{
    @XmlTransient
    private static Long count = 0l;

    @XmlTransient
    @NotNull
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    @XmlElement
    @NotNull
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
    public Flat(String args[]){
        house = new House();
        coordinates = new Coordinates();
        numberOfRooms = new Long(0);
        creationDate = ZonedDateTime.now();
        id = count;
        count += 1;
        name=args[0];
        coordinates.setX(Float.parseFloat(args[1]));
        coordinates.setY(Float.parseFloat(args[2]));
        area = Float.parseFloat(args[3]);
        balcony = Boolean.parseBoolean(args[4]);
        numberOfRooms = Long.parseLong(args[5]);
        price = Integer.parseInt(args[6]);
        furnish = Furnish.valueOf(args[7]);
        house.setName(args[8]);
        house.setYear(Long.parseLong(args[9]));
        house.setNumberOfFloors(Integer.parseInt(args[10]));
        house.setNumberOfFlatsOnFloor(Integer.parseInt(args[11]));
        house.setNumberOfLifts(Long.parseLong(args[12]));


    }
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

    public Integer getPrice() {
        return price;
    }

    public float getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public Long getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCoordinates(float x, Float y) {

        coordinates.setX(x);
        coordinates.setY(y);
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
   }

    public void setArea(float area) {
        this.area = area;
    }

    public void setNumberOfRooms(Long numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setBalcony(Boolean balcony) {
        this.balcony = balcony;
    }

    public void setFurnish(Furnish furnish) {
        this.furnish = furnish;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void setHouse(String name, Long year, Integer numberOfFloors, int numberOfFlatsOnFloor, Long numberOfLifts) {
        house.setName(name);
        house.setYear(year);
        house.setNumberOfFloors(numberOfFloors);
        house.setNumberOfFlatsOnFloor(numberOfFlatsOnFloor);
        house.setNumberOfLifts(numberOfLifts);
    }


    public Long getId() {
        return id;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }


//    public ZonedDateTime getCreationDate() {
//        return creationDate;
//    }

    public Boolean getBalcony() {
        return balcony;
    }

    public Furnish getFurnish() {
        return furnish;
    }

    public House getHouse() {
        return house;
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
