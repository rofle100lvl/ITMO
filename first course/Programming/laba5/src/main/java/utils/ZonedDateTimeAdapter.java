package utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Класс для успешного маршаллинга даты создания переменной
 */
public class ZonedDateTimeAdapter extends XmlAdapter<String, ZonedDateTime> {

    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String marshal(ZonedDateTime dateTime) {
        return dateTime.format(dateFormat);
    }

    @Override
    public ZonedDateTime unmarshal(String dateTime) {
        return ZonedDateTime.parse(dateTime, dateFormat);
    }

}