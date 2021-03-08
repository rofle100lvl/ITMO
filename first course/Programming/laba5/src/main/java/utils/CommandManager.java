package utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import CollectionManager.Flats;
import commands.*;

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

    public List<AbstractCommand> getCommands() {
        return commands;
    }

    public boolean noSuchCommand(String command) {
        System.out.println("Команда '" + command + "' не найдена. Наберите 'help' для справки.");
        return false;
    }
    public boolean printFieldDescendingHouse(String argument){
        return printFieldDescendingHouseCommand.execute(argument);
    }

    public void help() {

            for (Command command : commands) {
                System.out.println(command.getName() + " - " +  command.getDescription());
            }
    }
    public boolean executeScript(String argument){

        return executeScriptCommand.findCycles(argument);

    }
    public boolean info(String argument) {
        return infoCommand.execute(argument);
    }

    public boolean show(String argument) {
        return showCommand.execute(argument);
    }


    public boolean add(String arguments) {
         return addCommand.execute(arguments);
    }

    public boolean update(String argument) {
         return updateCommand.execute(argument);
    }


    public boolean removeById(String argument) {
        return removeByIdCommand.execute(argument);
    }
    public boolean printUniquePrice(String argument){
        return printUniquePrice.execute(argument);
    }

    public boolean clear(String argument) {
        return clearCommand.execute(argument);
    }


    public boolean save(String argument){
        return saveCommand.execute(argument);
    }


    public boolean exit(String argument) {
         return exitCommand.execute(argument);
    }


   // public boolean executeScript(String argument) {
    //    return executeScriptCommand.execute(argument);
   // }


    public boolean addIfMax(String argument) {
       return addIfMaxCommand.execute(argument);
    }

    public boolean remove_head(String argument){
        return removeHeadCommand.execute(argument);
    }
    public boolean head(String argument) {
        return headCommand.execute(argument);
    }

    public boolean removeHead(String argument) {
        return removeHeadCommand.execute(argument);
    }


    public boolean filterLessThanNumberOfRoomsCommand(String argument) {
         return filterLessThanNumberOfRoomsCommand.execute(argument);
    }

    @Override
    public String toString() {
        return "CommandManager - класс для работы с коммандами.";
    }
}