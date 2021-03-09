package commands;

import CollectionManager.Flats;
import utils.Parser;
import utils.UserAsker;

/**
 * Класс команды, сохраняющей коллекцию в файл
 */

public class SaveCommand extends AbstractCommand {
    public SaveCommand(UserAsker userAsker,Flats flats) {

        super("save", "Сохранение коллекции в файл");
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
        Parser.convertObjectToXml(flats, argument);
        return true;
    }
}