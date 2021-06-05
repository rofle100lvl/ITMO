package utils;

import java.io.*;
import java.util.*;

import CollectionManager.Flats;

/**
 * Класс Menu используется для обработки запросов пользователя
 */
public class Menu {

    private static String inputFile = System.getenv("nameOfFile");
    private static String outputFile = "outputData.xml";
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Flats flats;
    UserAsker userAsker;

    Stack<String>scriptStack = new Stack<>();

    private void validateStartFile(){
        if(inputFile==null || inputFile.isEmpty()) {
            System.out.println("Переменной окружения не существует.");
            askNewInputFile();
            return;
        }
        File newInputFile = new File(inputFile);
        if(!newInputFile.exists()) {
            System.out.println("Файл отсутсвует по указанному пути.");
            askNewInputFile();
            return;
        }
        if(!newInputFile.canRead()){
            System.out.println("Файл не имеет прав на чтение.");
            askNewInputFile();
        }
    }

    private void askNewInputFile(){
        while(true) {
            System.out.println("Введите путь к стартовому файлу:");
            try {
                inputFile = reader.readLine();
            } catch (IOException e) {
                System.out.println("Операция ввода-вывода завершилась неудачно или была прервана");
            }
            File newInputFile = new File(inputFile);
            if (newInputFile.exists() && newInputFile.canRead())break;
            else System.out.println("Введённый файл не существует или у него отсутствуют права на чтение.");
        }
    }

    /**
     * Конструктор
     */
    public Menu() {
        userAsker = new UserAsker(reader);
        validateStartFile();
        flats = Parser.fromXmlToObject(inputFile);
        if(flats == null){
            flats = new Flats();
        }
        flats.sort();
        commandManager = new CommandManager(userAsker,flats);
        System.out.println("***\tНачало работы. Для просмотра доступных команд напишите 'help'\t***");
        work(System.in);

    }

    CommandManager commandManager;

    /**
     * Метод для проверки колличества аргументов передаваемых пользователем
     * @param type - колличество параметров. Значение -1, соответствует произвольному числу параметров
     * @param arguments - исходный запрос пользователя.
     * @return - возвращает true, если проврка ушла успешно и false в обратном случае
     */
    public boolean validateCountArgs(int type, String arguments) {
        String[] words_request;
        words_request = arguments.split(" ");
        if (type == 0 && words_request.length != 1) {
            System.out.println("Эта команда должна вводиться без параметров.");
            return false;
        } else if (type == 1 && words_request.length != 2) {
            System.out.println("Эта команда должна вводиться с одним параметром.");
            return false;
        } else if (type == -1 && words_request.length == 1) {
            System.out.println("У этой команды должен быть хотя бы один параметр.");
            return false;
        }
        return true;

    }

    /**
     * Основной метод обрабатывающий запросы пользователя
     * @param stream Поток, с которого будет происходить считывание запросов
     * @return Возвращает true, если работа завершена успешно
     */
    public Boolean work(InputStream stream) {
        String[] words_request;
        String request= "";
        reader = new BufferedReader(new InputStreamReader(stream));
        userAsker.setUserScanner(reader);
        while (true) {
            try {
                    request = reader.readLine();
            } catch (IOException ignored) {

            }
            try {
                request = request.trim();
                words_request = request.trim().split(" ");
            }catch(NullPointerException e){
                return true;
            }
            switch (words_request[0]) {
                case "help":{
                    if (validateCountArgs(0, request)) commandManager.help();
                    break;
                }
                case "remove_by_id": {
                    if (validateCountArgs(-1, request)) commandManager.removeById(request);
                    break;
                }
                case "update": {
                    if (validateCountArgs(1, request))
                        if(!commandManager.update(request)){
                            return false;
                        }
                    break;
                }
                case "print_field_descending_house":{
                    if(validateCountArgs(0,request))
                        if(!commandManager.printFieldDescendingHouse(request)){
                            return false;
                        }
                    break;
                }
                case "head": {
                    if (validateCountArgs(0, request))
                    commandManager.head(request);
                    break;
                }

                case "info": {
                    if (validateCountArgs(0, request))
                        commandManager.info(request);
                    break;
                }
                case "add_if_max":{
                    if (validateCountArgs(0, request))
                        if(!commandManager.addIfMax(request)){
                            return false;
                        }
                    System.out.println("Элемент успешно добавлен");
                    break;
                }
                case "execute_script": {
                        if (!validateCountArgs(1, request)) {
                            break;
                        }
                        if (!commandManager.executeScript(words_request[1])) {
                            break;
                        }
                        System.out.println("====  Начало выполнения скрипта по адресу " + words_request[1] + "  ====");
                    try {
                        if(!work(new BufferedInputStream(new FileInputStream( words_request[1])))){
                            reader = new BufferedReader(new InputStreamReader(stream));
                            userAsker.setUserScanner(reader);
                            System.out.println("В одном из файлов обнаружена ошибка. Перепроверьте скрипты.");
                            if(stream.equals(System.in)){
                                reader = new BufferedReader(new InputStreamReader(stream));
                                userAsker.setUserScanner(reader);
                                break;
                            }
                            return false;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Файл не найден или нарушены права доступа");
                    }
                    System.out.println("====  Скрипт " + words_request[1] + " успешно выполнен  ====\n");
                    reader = new BufferedReader(new InputStreamReader(stream));
                    userAsker.setUserScanner(reader);
                    break;
                }

                case "save": {
                    if (validateCountArgs(0, request))
                    commandManager.save(outputFile);
                    break;
                }

                case "show": {
                    if (validateCountArgs(0, request))
                    commandManager.show(request);
                    break;
                }
                case "filter_less_than_number_of_rooms": {
                    if (validateCountArgs(1, request))
                    commandManager.filterLessThanNumberOfRoomsCommand(request);
                    break;
                }
                case "print_unique_price": {
                    if (validateCountArgs(0, request))
                    commandManager.printUniquePrice(request);
                    break;
                }

                case "add": {
                    if (validateCountArgs(0, request)) {
                        if (!commandManager.add(request)) {
                            return false;
                        }
                        System.out.println("Элемент успешно добавлен");
                    }
                    break;
                }

                case "clear": {
                    if (validateCountArgs(0, request))
                    if(commandManager.clear(request)) System.out.println("Коллекция успешно очищена");
                    else System.out.println("Коллекция пуста");
                    break;
                }
                case "remove_head":
                    if (validateCountArgs(0, request)) {
                        if (commandManager.remove_head(request)) System.out.println("Первый элемент выведен и удалён");
                        else System.out.println("Коллекция пуста");
                    }
                    break;
                case "exit": {
                    return true;
                }
                default: {

                    System.out.println("Введённой команды не предусмотренно");
                }
            }
        }
    }

}
