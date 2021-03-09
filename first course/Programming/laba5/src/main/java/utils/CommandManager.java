package utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import CollectionManager.Flats;
import commands.*;

/**
 * Класс CommandManager используется для работы с камандами
 */
public class CommandManager {
    private final int COMMAND_HISTORY_SIZE = 8;
    private List<AbstractCommand> commands = new ArrayList<>();
    private AddCommand addCommand;
    private InfoCommand infoCommand;
    private ShowCommand showCommand;
    private PrintUniquePriceCommand printUniquePrice;
    private UpdateCommand updateCommand;
    private RemoveByIdCommand removeByIdCommand;
    private ClearCommand clearCommand;
    private SaveCommand saveCommand ;
    private ExitCommand exitCommand;
    private AddIfMaxCommand addIfMaxCommand;
    private HeadCommand headCommand;
    private PrintFieldDescendingHouseCommand printFieldDescendingHouseCommand;
    private RemoveHeadCommand removeHeadCommand;
    private FilterLessThanNumberOfRoomsCommand filterLessThanNumberOfRoomsCommand;
    private ExecuteScriptCommand executeScriptCommand;

    /**
     * Конструктор класса
     * @param userAsker
     * @param flats
     */
    public CommandManager(UserAsker userAsker, Flats flats){
        printFieldDescendingHouseCommand = new PrintFieldDescendingHouseCommand(userAsker, flats);
        addCommand = new AddCommand(userAsker, flats);
        infoCommand = new InfoCommand(userAsker,flats);
        showCommand = new ShowCommand(userAsker,flats);
        printUniquePrice = new PrintUniquePriceCommand(userAsker, flats);
        updateCommand = new UpdateCommand(userAsker,flats);
        removeByIdCommand = new RemoveByIdCommand(userAsker, flats);
        clearCommand = new ClearCommand(userAsker, flats);
        saveCommand = new SaveCommand(userAsker,flats);
        exitCommand = new ExitCommand();
        addIfMaxCommand = new AddIfMaxCommand(userAsker, flats);
        headCommand = new HeadCommand(userAsker, flats);
        removeHeadCommand = new RemoveHeadCommand(userAsker,flats);
        filterLessThanNumberOfRoomsCommand = new FilterLessThanNumberOfRoomsCommand(userAsker,flats);
        executeScriptCommand = new ExecuteScriptCommand();

        commands.add(addCommand);
        commands.add(executeScriptCommand);
        commands.add(printUniquePrice);
        commands.add(infoCommand);
        commands.add(showCommand);
        commands.add(updateCommand);
        commands.add(removeByIdCommand);
        commands.add(clearCommand);
        commands.add(saveCommand);
        commands.add(addIfMaxCommand);
        commands.add(headCommand);
        commands.add(removeHeadCommand);
        commands.add(filterLessThanNumberOfRoomsCommand);
    }

    /**
     * Метод возвращающий список команд
     * @return Возвращает список команд
     */
    public List<AbstractCommand> getCommands() {
        return commands;
    }

    /**
     * Вызывает команду FieldDescendingHouse
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда выполнена удачно
     */
    public boolean printFieldDescendingHouse(String argument){
        return printFieldDescendingHouseCommand.execute(argument);
    }
    /**
     * Выводит на экран список всех доступных команд
     */
    public void help() {

            for (Command command : commands) {
                System.out.println(command.getName() + " - " +  command.getDescription());
            }
    }

    /**
     * Вызывает команду ExecuteScript
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда выполнена удачно
     */
    public boolean executeScript(String argument){

        return executeScriptCommand.findCycles(argument);

    }
    /**
     * Вызывает команду Info
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда выполнена удачно
     */
    public boolean info(String argument) {
        return infoCommand.execute(argument);
    }
    /**
     * Вызывает команду Show
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда выполнена удачно
     */
    public boolean show(String argument) {
        return showCommand.execute(argument);
    }

    /**
     * Вызывает команду Add
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда выполнена удачно
     */
    public boolean add(String argument) {
         return addCommand.execute(argument);
    }

    /**
     * Вызывает команду Update
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда выполнена удачно
     */
    public boolean update(String argument) {
         return updateCommand.execute(argument);
    }

    /**
     * Вызывает команду RemoveById
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда выполнена удачно
     */
    public boolean removeById(String argument) {
        return removeByIdCommand.execute(argument);
    }

    /**
     * Вызывает команду PrintUniquePrice
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда выполнена удачно
     */

    public boolean printUniquePrice(String argument){
        return printUniquePrice.execute(argument);
    }

    /**
     * Вызывает команду Clear
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда выполнена удачно
     */

    public boolean clear(String argument) {
        return clearCommand.execute(argument);
    }

    /**
     * Вызывает команду Save
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда выполнена удачно
     */

    public boolean save(String argument){
        return saveCommand.execute(argument);
    }

    /**
     * Вызывает команду AddIfMax
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда выполнена удачно
     */

    public boolean addIfMax(String argument) {
       return addIfMaxCommand.execute(argument);
    }

    /**
     * Вызывает команду RemoveHead
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда выполнена удачно
     */

    public boolean remove_head(String argument){
        return removeHeadCommand.execute(argument);
    }
    /**
     * Вызывает команду Head
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда выполнена удачно
     */
    public boolean head(String argument) {
        return headCommand.execute(argument);
    }

    /**
     * Вызывает команду FilterLessThanNumberOfRooms
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда выполнена удачно
     */

    public boolean filterLessThanNumberOfRoomsCommand(String argument) {
         return filterLessThanNumberOfRoomsCommand.execute(argument);
    }

    /**
     * Выводит информацию о классе
     * @return Возвращает строку информации о классе
     */
    @Override
    public String toString() {
        return "CommandManager - класс для работы с коммандами.";
    }
}