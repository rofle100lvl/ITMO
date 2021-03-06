import startClasses.Coordinates;
import startClasses.House;
import utils.CommandManager;
import utils.Parser;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;

import CollectionManager.Flats;
import startClasses.Flat;
import utils.Validator;

public class Menu {

    private static String inputFile = "src" + File.separator + "main" + File.separator + "resources" + File.separator + System.getenv("nameOfFile");
    private static String outputFile = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "outputData.xml";
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Flats flats;
    private String words_request[];
    String request;

    ArrayList<ArrayList<String>> edgesFiles;

    public Menu() {
        flats = Parser.fromXmlToObject(inputFile);
        flats.sort();
        if (!work()) {
            work();
        }
    }

    CommandManager commandManager = new CommandManager();

    public boolean validateCountArgs(int type, String arguments) {
        words_request = arguments.split(" ");
        if (type == 0 && words_request.length != 1) {
            System.out.println("Эта компанда должна вводиться без параметров.");
            return false;
        } else if (type == 1 && words_request.length != 2) {
            System.out.println("Эта компанда должна вводиться с одним параметром.");
            return false;
        } else if (type == -1 && words_request.length == 1) {
            System.out.println("У этой команды должен быть хотя бы один параметр.");
            return false;
        }
        return true;

    }

    public Boolean work() {
        while (1 == 1) {
            try {
                request = reader.readLine();
            } catch (IOException e) {

            }
            words_request = request.split(" ");

            switch (words_request[0]) {

                case "help":{
                    if (validateCountArgs(0, request)) commandManager.help();
                    break;
                }
                case "remove_by_id": {
                    if (validateCountArgs(-1, request)) commandManager.removeById(request, flats);
                    break;
                }
                case "update": {
                    if (validateCountArgs(1, request))
                        commandManager.update(request, flats);
                    break;
                }
                case "head": {
                    if (validateCountArgs(0, request))
                    commandManager.head(request, flats);
                    break;
                }

                case "info": {
                    if (validateCountArgs(0, request))
                    commandManager.info(request, flats);
                    break;
                }

                case "execute_script": {
                    if(validateCountArgs(1,request) && commandManager.executeScript(words_request[1])){
                        try {
                            reader = new BufferedReader(new FileReader(words_request[1]));
                        } catch (FileNotFoundException e) {

                        }
                    }
                    break;
                }

                case "save": {
                    if (validateCountArgs(0, request))
                    commandManager.save(outputFile, flats);
                    break;
                }

                case "show": {
                    if (validateCountArgs(0, request))
                    commandManager.show(request, flats);
                    break;
                }
                case "filter_less_than_number_of_rooms": {
                    if (validateCountArgs(1, request))
                    commandManager.filterLessThanNumberOfRoomsCommand(request, flats);
                    break;
                }
                case "print_unique_price": {
                    if (validateCountArgs(0, request))
                    commandManager.printUniquePrice(request, flats);
                    break;
                }

                case "add": {
                    if (validateCountArgs(0, request))
                    commandManager.add(request, flats);
                    break;
                }

                case "clear": {
                    if (validateCountArgs(0, request))
                    commandManager.clear(request, flats);
                    break;
                }

                case "exit": {
                    return true;
                }
                default: {

                }
            }
        }
    }


}
