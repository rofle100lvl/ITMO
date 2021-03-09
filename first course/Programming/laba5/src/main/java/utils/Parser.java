package utils;

import javax.xml.bind.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import CollectionManager.Flats;
import startClasses.*;

/**
 * Класс для преобразование xml файла в коллекцию
 */
public class Parser {

    private final static ArrayList<Class> wrapperClasses = new ArrayList<>(Arrays.asList(new Class[]{
            Byte.class,
            Short.class,
            Integer.class,
            Long.class,
            Float.class,
            Double.class,
            Boolean.class,
            Character.class
    }));

    /**
     * Метод создающий коллекцию объектов из xml файла
     * @param filePath Путь к файлу
     * @return Класс, содержащий коллекцию элементов
     */
    public static Flats fromXmlToObject(String filePath) {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Flats.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            Flats flats = (Flats) un.unmarshal(new File(filePath));
            for(int i=0;i<flats.getFlats().size();i++){
                Validator validator = new Validator(Flat.class);
                if(!validator.validate(flats.getFlats().get(i))){
                    System.out.printf("В %d квартире найдена ошибка в файле. В файле startData.xml введны некорректные данные.\n",i+1);
                    flats.removeId((long) i);
                }
            }
            return flats;
        } catch (JAXBException | IllegalAccessException e) {
            System.out.println("Стартовый файл не найден или нарушены права доступа");
        }
        return null;
    }

    /**
     * Метод преобразовывающий коллекция в xml файл
     * @param flats Класс, содержащий коллекцию
     * @param filePath Путь к файлу
     */
    public static void convertObjectToXml(Flats flats, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Flats.class, Flat.class, Coordinates.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(flats, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод возвращаюший все примитивные и ссылочные типы, используемые в классе
     * @return Массив классов полей класса Flat
     */
    public static ArrayList<Class> getWrapperClasses(){
        return wrapperClasses;
    }
}