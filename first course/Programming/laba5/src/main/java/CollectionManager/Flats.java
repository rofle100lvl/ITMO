package CollectionManager;


import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import startClasses.*;
import utils.ZonedDateTimeAdapter;

/**
 * Класс для коллеции и операций над ней
 */
@XmlRootElement(name = "Flats")
@XmlAccessorType(XmlAccessType.FIELD)
public class Flats {
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    @XmlElement(name = "creationCollectionDate")
    private java.time.ZonedDateTime creationDate;
    @XmlElement(name = "flat")
    private LinkedList<Flat> flats = new LinkedList<Flat>();

    public Flats() {
        creationDate = ZonedDateTime.now();
    }

    /**
     * Метод, выводящий информацию о коллекции
     */
    public void getInfo() {
        System.out.println("Размер коллекции: " + flats.size());
        System.out.println("Дата создания коллекции: " + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(creationDate));
    }

    /**
     * Метод, удаляющий элемент по id
     * @param id id элемента, который надо удалить
     * @return Возвращает true, если элемент с таким id существует
     */
    public boolean removeId(Long id) {
        for (Flat flat : flats) {
            if (flat.getId().equals(id)) {
                flats.remove(flat);
                return true;
            }
        }
        return false;
    }

    public LinkedList<Flat> getFlats() {
        return flats;
    }

    /**
     * Выводит первый элемент массива
     */
    public void head() throws IndexOutOfBoundsException {
        try {
            System.out.println(flats.get(0).niceToString());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Коллекция пуста");
        }
    }

    /**
     * Очищает коллекцию
     * @return Возвращает false, если коллекция - пуста
     */
    public boolean clear() {
        if(flats.size()==0)return false;
        flats.clear();
        return true;
    }

    /**
     * Выводит все элемент коллекции
     */
    public void show() {
        for (Flat flat : flats) System.out.println(flat.niceToString());
    }

    /**
     * Добавляет элемент в коллекцию
     */
    public void addElement(Flat a) {
        flats.add(a);
    }

    /**
     * Сортирует коллекцию
     */
    public void sort(){
        Collections.sort(flats);
    }


}
