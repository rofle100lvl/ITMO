package CollectionManager;


import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.ZonedDateTime;
import java.util.*;

import startClasses.*;
import utils.ZonedDateTimeAdapter;

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

    public void getInfo() {
        System.out.println(flats.size());
        System.out.println(creationDate);
        System.out.println(Flats.class);
    }

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

    public void head() throws IndexOutOfBoundsException {
        try {
            System.out.println(flats.get(0).niceToString());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Коллекция пуста");
        }
    }

    public void clear() {

        flats.clear();
        System.out.println("Коллекция отчислена");
    }

    public void show() {
        for (Flat flat : flats) System.out.println(flat.niceToString());
    }

    public void addElement(Flat a) {
        flats.add(a);
    }

    public void sort(){
        Collections.sort(flats);
    }


}
