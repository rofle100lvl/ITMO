package commands;

import CollectionManager.Flats;
import utils.UserAsker;
/**
 * Класс команды чистки коллекции
 */
public class ClearCommand extends AbstractCommand {
    public ClearCommand(UserAsker userAsker, Flats flats)
    {
        super("clear", "Очистка коллекции");
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
        return flats.clear();
    }
}