package commands;

import CollectionManager.Flats;
import startClasses.Coordinates;
import startClasses.Flat;
import startClasses.House;
import utils.UserAsker;
import utils.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class UpdateCommand extends AbstractCommand {
    public UpdateCommand(UserAsker userAsker, Flats flats) {
        super("update", "Обновляет значение элемента коллекции, id которого равен заданному");
        setFlats(flats);
        setUserAsker(userAsker);
    }

    @Override
    public boolean execute(String argument) {
       String [] wordsRequest=argument.split(" ");
       Long id = Long.parseLong(wordsRequest[1]);

        for (int i = 0; i < flats.getFlats().size(); i++) {
            if (flats.getFlats().get(i).getId().equals(id)) {
                Validator validator = new Validator(Flat.class);
                String request;
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    while (true) {
                        System.out.printf("Введите name: ");
                        request = reader.readLine();
                        if(request == null)return false;
                        if (validator.validateField(request, flats.getFlats().get(i).getClass().getDeclaredField("name"), flats.getFlats().get(i)))
                            break;
                        else System.out.println("Произошла ошибка при вводе поля. Ожидался не пустой String.");
                    }

                    while (true) {
                        System.out.printf("Введите площадь квартиры: ");
                        request = reader.readLine();
                        if(request == null)return false;
                        if (validator.validateField(request, flats.getFlats().get(i).getClass().getDeclaredField("area"), flats.getFlats().get(i)))
                            break;
                        else System.out.println("Произошла ошибка при вводе поля. Ожидался float.");
                    }

                    while (true) {
                        System.out.printf("Есть ли балкон (true/false): ");
                        request = reader.readLine();
                        if(request == null)return false;
                        if (validator.validateField(request, flats.getFlats().get(i).getClass().getDeclaredField("balcony"), flats.getFlats().get(i)))
                            break;
                        else System.out.println("Произошла ошибка при вводе поля. Ожидался Boolean.");
                    }

                    while (true) {
                        System.out.printf("Введите колличество комнат: ");
                        request = reader.readLine();
                        if(request == null)return false;
                        if (validator.validateField(request, flats.getFlats().get(i).getClass().getDeclaredField("numberOfRooms"), flats.getFlats().get(i)))
                            break;
                        else System.out.println("Произошла ошибка при вводе поля. Ожидался Long.");
                    }

                    while (true) {
                        System.out.printf("Введите цену: ");
                        request = reader.readLine();
                        if(request == null)return false;
                        if (validator.validateField(request, flats.getFlats().get(i).getClass().getDeclaredField("price"), flats.getFlats().get(i)))
                            break;
                        else System.out.println("Произошла ошибка при вводе поля. Ожидался Integer.");
                    }

                    while (true) {
                        System.out.printf("Обозначьте дизайн(DESIGNER/NONE/FINE/LITTLE): ");
                        request = reader.readLine();
                        if(request == null)return false;
                        if (validator.validateField(request,flats.getFlats().get(i).getClass().getDeclaredField("furnish"), flats.getFlats().get(i)))
                            break;
                        else System.out.println("Произошла ошибка при вводе поля. Ожидался String.");
                    }
                    validator = new Validator(House.class);
                    House house = new House();
                    while (true) {
                        System.out.printf("Введите имя дома: ");
                        request = reader.readLine();
                        if(request == null)return false;
                        if (validator.validateField(request, house.getClass().getDeclaredField("name"), house)) break;
                        else System.out.println("Произошла ошибка при вводе поля. Ожидался не пустой String.");
                    }

                    while (true) {
                        System.out.printf("Введите год постройки дома: ");
                        request = reader.readLine();
                        if(request == null)return false;
                        if (validator.validateField(request, house.getClass().getDeclaredField("year"), house)) break;
                        else System.out.println("Произошла ошибка при вводе поля. Ожидался Long.");
                    }
                    while (true) {
                        System.out.printf("Введите колличество этажей: ");
                        request = reader.readLine();
                        if(request == null)return false;
                        if (validator.validateField(request, house.getClass().getDeclaredField("numberOfFloors"), house))
                            break;
                        else System.out.println("Произошла ошибка при вводе поля. Ожидался Integer.");
                    }
                    while (true) {
                        System.out.printf("Введите колличество этажей: ");
                        request = reader.readLine();
                        if(request == null)return false;
                        if (validator.validateField(request, house.getClass().getDeclaredField("numberOfFloors"), house))
                            break;
                        else System.out.println("Произошла ошибка при вводе поля. Ожидался Integer.");
                    }

                    while (true) {
                        System.out.printf("Введите колличество квартир на этаже: ");
                        request = reader.readLine();
                        if(request == null)return false;
                        if (validator.validateField(request, house.getClass().getDeclaredField("numberOfFlatsOnFloor"), house))
                            break;
                        else System.out.println("Произошла ошибка при вводе поля. Ожидался Integer.");
                    }

                    while (true) {
                        System.out.printf("Введите колличество лифтов: ");
                        request = reader.readLine();
                        if(request == null)return false;
                        if (validator.validateField(request, house.getClass().getDeclaredField("numberOfLifts"), house))
                            break;
                        else System.out.println("Произошла ошибка при вводе поля. Ожидался Long.");
                    }
                    flats.getFlats().get(i).setHouse(house);
                    validator = new Validator(Coordinates.class);
                    Coordinates coordinates = new Coordinates();
                    while (true) {
                        System.out.printf("Введите координату x: ");
                        request = reader.readLine();
                        if(request == null)return false;
                        if (validator.validateField(request, coordinates.getClass().getDeclaredField("x"), coordinates))
                            break;
                        else System.out.println("Произошла ошибка при вводе поля. Ожидался Float.");
                    }
                    while (true) {
                        System.out.printf("Введите координату y: ");
                        request = reader.readLine();
                        if(request == null)return false;
                        if (validator.validateField(request, coordinates.getClass().getDeclaredField("y"), coordinates))
                            break;
                        else System.out.println("Произошла ошибка при вводе поля. Ожидался Float.");
                    }

                    flats.getFlats().get(i).setCoordinates(coordinates);

                } catch (IOException | NoSuchFieldException e) {

                }
                System.out.println("Элемент успешно изменён");
                return true;
            }
        }
        System.out.println("Элемента с данным id не существует");
        return true;
    }


}