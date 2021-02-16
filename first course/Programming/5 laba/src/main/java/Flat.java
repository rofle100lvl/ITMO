public class Flat {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float area; //Значение поля должно быть больше 0
    private Long numberOfRooms; //Поле может быть null, Значение поля должно быть больше 0
    private Integer price; //Максимальное значение поля: 121887043, Значение поля должно быть больше 0
    private Boolean balcony; //Поле может быть null
    private Furnish furnish; //Поле может быть null
    private House house; //Поле может быть null
    public Flat(){
        house=new House();
        coordinates=new Coordinates();
    }
}
