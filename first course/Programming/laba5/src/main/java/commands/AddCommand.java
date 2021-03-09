package commands;

import CollectionManager.Flats;
import startClasses.Coordinates;
import startClasses.Flat;
import startClasses.House;
import utils.UserAsker;
import utils.Validator;

import java.io.*;
import java.util.stream.Stream;

/**
 * Класс команды добавления экземпляра в коллекцию
 */
public class AddCommand extends AbstractCommand {
    public AddCommand(UserAsker userAsker, Flats flats) {
        super("add", "Добавляет новый элемент в коллекцию");
        setFlats(flats);
        setUserAsker(userAsker);

    }


    /**
     * Метод запускающий команду
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда обработана
     */
    @Override
    public boolean execute(String argument) {
        BufferedReader reader;
        reader = userAsker.getUserScanner();
        try {
            Flat flat = new Flat();
            Validator validator = new Validator(Flat.class);
            String request = "";

            while (true) {
                System.out.print("Введите name: ");
                request = reader.readLine();
                if(request == null)return false;
                flat.setName(flat.getName());
                if (validator.validateField(request, flat.getClass().getDeclaredField("name"), flat)) break;
                else{
                    if(userAsker.isFileMode()) System.out.println();
                    System.out.println("Произошла ошибка при вводе поля. Ожидался не пустой String.");
                }
            }
            if(userAsker.isFileMode()) System.out.println(request);


            while (true) {
                System.out.printf("Введите площадь квартиры: ");
                request = reader.readLine();
                if(request == null)return false;
                if (validator.validateField(request, flat.getClass().getDeclaredField("area"), flat)) break;
                else {
                    if (userAsker.isFileMode()) System.out.println();
                    System.out.println("Произошла ошибка при вводе поля. Ожидался float.");
                }
                }
            if(userAsker.isFileMode()) System.out.println(request);

            while (true) {
                System.out.printf("Есть ли балкон (true/false): ");
                request = reader.readLine();
                if(request == null)return false;
                if (validator.validateField(request, flat.getClass().getDeclaredField("balcony"), flat)) break;
                else {
                    if (userAsker.isFileMode()) System.out.println();
                    System.out.println("Произошла ошибка при вводе поля. Ожидался Boolean.");
                }
                }
            if(userAsker.isFileMode()) System.out.println(request);

            while (true) {
                System.out.printf("Введите колличество комнат: ");
                request = reader.readLine();
                if(request == null)return false;
                if (validator.validateField(request, flat.getClass().getDeclaredField("numberOfRooms"), flat)) break;
                else {
                    if (userAsker.isFileMode()) System.out.println();
                    System.out.println("Произошла ошибка при вводе поля. Ожидался Long.");
                }
            }
            if(userAsker.isFileMode()) System.out.println(request);

            while (true) {
                System.out.printf("Введите цену: ");
                request = reader.readLine();
                if(request == null)return false;
                if (validator.validateField(request, flat.getClass().getDeclaredField("price"), flat)) break;
                else {
                    if (userAsker.isFileMode()) System.out.println();
                    System.out.println("Произошла ошибка при вводе поля. Ожидался Integer.");
                }
            }
            if(userAsker.isFileMode()) System.out.println(request);

            while (true) {
                System.out.printf("Обозначьте дизайн(DESIGNER/NONE/FINE/LITTLE): ");
                request = reader.readLine();
                if(request == null)return false;
                if (validator.validateField(request, flat.getClass().getDeclaredField("furnish"), flat)) break;
                else {
                    if (userAsker.isFileMode()) System.out.println();
                    System.out.println("Произошла ошибка при вводе поля. Ожидался String.");
                }
            }
            if(userAsker.isFileMode()) System.out.println(request);

            validator = new Validator(House.class);
            House house = new House();
            while (true) {
                System.out.printf("Введите имя дома: ");
                request = reader.readLine();
                if(request == null)return false;
                if (validator.validateField(request, house.getClass().getDeclaredField("name"), house)) break;
                else {
                    if (userAsker.isFileMode()) System.out.println();
                    System.out.println("Произошла ошибка при вводе поля. Ожидался не пустой String.");
                }
            }
            if(userAsker.isFileMode()) System.out.println(request);

            while (true) {
                System.out.printf("Введите год постройки дома: ");
                request = reader.readLine();
                if(request == null)return false;
                if (validator.validateField(request, house.getClass().getDeclaredField("year"), house)) break;
                else {
                    if (userAsker.isFileMode()) System.out.println();
                    System.out.println("Произошла ошибка при вводе поля. Ожидался Long.");
                }
            }
            if(userAsker.isFileMode()) System.out.println(request);

            while (true) {
                System.out.printf("Введите колличество этажей: ");
                request = reader.readLine();
                if(request == null)return false;
                if (validator.validateField(request, house.getClass().getDeclaredField("numberOfFloors"), house)) break;
                else {
                    if (userAsker.isFileMode()) System.out.println();
                    System.out.println("Произошла ошибка при вводе поля. Ожидался Integer.");
                }
            }
            if(userAsker.isFileMode()) System.out.println(request);

            while (true) {
                System.out.printf("Введите колличество квартир на этаже: ");
                request = reader.readLine();
                if(request == null)return false;
                if (validator.validateField(request, house.getClass().getDeclaredField("numberOfFlatsOnFloor"), house))
                    break;
                else {
                    if (userAsker.isFileMode()) System.out.println();
                    System.out.println("Произошла ошибка при вводе поля. Ожидался Integer.");
                }
            }
            if(userAsker.isFileMode()) System.out.println(request);

            while (true) {
                System.out.printf("Введите колличество лифтов: ");
                request = reader.readLine();
                if(request == null)return false;
                if (validator.validateField(request, house.getClass().getDeclaredField("numberOfLifts"), house)) break;
                else {
                    if (userAsker.isFileMode()) System.out.println();
                    System.out.println("Произошла ошибка при вводе поля. Ожидался Long.");
                }
            }
            if(userAsker.isFileMode()) System.out.println(request);

            flat.setHouse(house);
            validator = new Validator(Coordinates.class);
            Coordinates coordinates = new Coordinates();
            while (true) {
                System.out.printf("Введите координату x: ");
                request = reader.readLine();
                if(request == null)return false;
                if (validator.validateField(request, coordinates.getClass().getDeclaredField("x"), coordinates)) break;
                else {
                    if (userAsker.isFileMode()) System.out.println();
                    System.out.println("Произошла ошибка при вводе поля. Ожидался Float.");
                }
            }
            if(userAsker.isFileMode()) System.out.println(request);

            while (true) {
                System.out.printf("Введите координату y: ");
                request = reader.readLine();
                if(request == null)return false;
                if (validator.validateField(request, coordinates.getClass().getDeclaredField("y"), coordinates)) break;
                else {
                    if (userAsker.isFileMode()) System.out.println();
                    System.out.println("Произошла ошибка при вводе поля. Ожидался Float.");
                }
            }
            if(userAsker.isFileMode()) System.out.println(request);

            validator = new Validator(Flat.class);
            flat.setCoordinates(coordinates);
            flats.addElement(flat);

        } catch (IOException | NoSuchFieldException e) {

        }
        return true;
    }
}
