package utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import CollectionManager.Flats;
import startClasses.*;
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
    // восстанавливаем объект из XML файла
    public static Flats fromXmlToObject(String filePath) {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Flats.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            Flats flats = (Flats) un.unmarshal(new File(filePath));
            for(int i=0;i<flats.getFlats().size();i++){
                Validator validator = new Validator(Flat.class);
                if(!validator.validate(flats.getFlats().get(i))){
                    System.out.printf("В %d квартире найдена ошибка в файле. в файле startData.xml введны некорректные данные\n",i);
                    flats.removeId((long) i);
                }
            }
            return flats;
        } catch (JAXBException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    // сохраняем объект в XML файл
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
    public static ArrayList<Class> getWrapperClasses(){
        return wrapperClasses;
    }
}