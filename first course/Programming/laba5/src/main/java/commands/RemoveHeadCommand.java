package commands;

import CollectionManager.Flats;
import utils.UserAsker;

/**
 * Класс команды, выводящей первый элемент и удаляющей его
 */
public class RemoveHeadCommand extends AbstractCommand {
    public RemoveHeadCommand(UserAsker userAsker,Flats flats) {

        super("head", "Вывод первого элемента коллекции и удаление его");
        setUserAsker(userAsker);
        setFlats(flats);
    }

    /**
     * Метод запускающий команду
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда обработана
     */
    @Override
    public boolean execute(String argument) {
        if (flats.getFlats().size() > 0) {
            flats.head();
            flats.getFlats().removeFirst();
            return true;
        } else return false;
    }
}