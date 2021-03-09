package commands;

import CollectionManager.Flats;
import utils.UserAsker;
/**
 * Класс команды вывода всех квартир, значение поля numberOfRooms которых меньше заданного
 */
public class FilterLessThanNumberOfRoomsCommand extends AbstractCommand {
    public FilterLessThanNumberOfRoomsCommand(UserAsker userAsker,Flats flats) {
        super("filter_less_than_number_of_rooms", "Выводит элементы, значение поля numberOfRooms которых меньше заданного");
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
        String[] wordsRequest = argument.split(" ");
        try {
            Long numberOfRooms = Long.parseLong(wordsRequest[1]);
            for(int i=0;i<flats.getFlats().size();i++){
                if(flats.getFlats().get(i).getNumberOfRooms()<numberOfRooms){
                    System.out.println(flats.getFlats().get(i).toString());
                }
            }
        }
        catch(NumberFormatException e){
            System.out.println("Произошла ошибка при вводе поля. Ожидался Long.");
            return false;
        }
        return true;

    }
}