package commands;

import CollectionManager.Flats;
import utils.UserAsker;

/**
 * Класс команды выхода информации о коллекции
 */
public class InfoCommand extends AbstractCommand{
    public InfoCommand(UserAsker userAsker,Flats flats)
    {
        super("info", "Выводит информацию о коллекции");
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
        flats.getInfo();
        return true;
    }
}
