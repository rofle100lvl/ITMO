package commands;

import CollectionManager.Flats;

/**
 * Interface for all commands.
 */
public interface Command {
    /**
     *
     * @return Возвращает описание команды
     */
    String getDescription();

    /**
     *
     * @return Возвращает имя команды
     */
    String getName();

    /**
     * Метод запускающий команду
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда обработана
     */
    boolean execute(String argument);
}