import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
public class Menu {
    LinkedList<Object> linkedList = new LinkedList<Object>();
    Scanner inConsole=new Scanner(System.in);
    void working(){

    }

    public Menu() throws java.io.IOException, ParserConfigurationException, SAXException, IllegalAccessException, NoSuchFieldException {
        Parser parser = new Parser();
        parser.parse();


    }


}
