import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;


public class Parser {
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    public  Parser() throws ParserConfigurationException, IOException, SAXException {

    }
    public void parse() throws IOException, SAXException, ParserConfigurationException, IllegalAccessException, NoSuchFieldException {
        //Генерация документа содержащего дерево xml
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = (Document) builder.parse(new File( "src" + File.separator + "main" +File.separator + "resources" + File.separator + System.getenv("nameOfFile")));

        //Создание корневого элемента и запуск рекурсии

        Element element = document.getDocumentElement();
        rec(element.getChildNodes());

    }
    public void rec(NodeList nodeList) throws IllegalAccessException, NoSuchFieldException {
        for (int i = 0; i < nodeList.getLength(); i++) {
            //Создаём экземпляр квартиры, который позже положим в коллецию
            Flat flat = new Flat();

            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                //Создаём элемент тега<house>
                Element element = (Element) nodeList.item(i);

                System.out.println(element.getTagName());
                NamedNodeMap attributes=element.getAttributes();
                //Берём все поля flat
                Field[] flatFields=flat.getClass().getDeclaredFields();

                //Разрешаем к ним доступ
                for(Field field:flatFields)field.setAccessible(true);

                //Идём по атрибутам полям класса и пихаем туда значения из атрибутов house
                for(Field field:flatFields) {
                    if(element.hasAttribute(field.getName())){
                        field.set(flat,element.getAttribute(field.getName()));
                        break;
                    }
                }

                //Дети элемента flat, то есть house,coordinates,Furnish
                NodeList nodeList1=element.getChildNodes();

                //Бежим по детям flat
                for(int j=0;j<nodeList1.getLength();j++){
                    if (nodeList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        //Ребёнок flat
                        Element el = (Element) nodeList1.item(j);

                        //Находим поле класса flat с названием тэга
                        Field field = flat.getClass().getDeclaredField(el.getTagName());
                        field.setAccessible(true);
                        //Создаём объекта этого класса и берём его методы
                        Object obj = field.get(flat);
                        Field[] objectFields = obj.getClass().getDeclaredFields();
                        //Бежим по этим методам и пытаемся их установить, но ничего не работает.
                        for (Field fieldF : objectFields) {
                            fieldF.setAccessible(true);
                            fieldF.set(flat,Float.parseFloat( el.getAttribute(fieldF.getName())));

                        }
                        //Я не знаю, как правильно оформить эту рефлексию, мучаюсь уже третий день, такое ощущение, что
                        //я хожу по кругу. Нужна чья-то помощь желательно психолога.
                    }
                }
            }
        }
    }
}
