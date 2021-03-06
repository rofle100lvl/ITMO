package utils;

import java.util.ArrayList;
import java.util.List;

import CollectionManager.Flats;
import commands.*;

public class CommandManager {
    private final int COMMAND_HISTORY_SIZE = 8;
    private List<AbstractCommand> commands = new ArrayList<>();
    private AddCommand addCommand = new AddCommand();
    private InfoCommand infoCommand = new InfoCommand();
    private ShowCommand showCommand = new ShowCommand();
    private PrintUniquePriceCommand printUniquePrice = new PrintUniquePriceCommand();
    private UpdateCommand updateCommand = new UpdateCommand();
    private RemoveByIdCommand removeByIdCommand = new RemoveByIdCommand();
    private ClearCommand clearCommand = new ClearCommand();
    private SaveCommand saveCommand = new SaveCommand();
    private ExitCommand exitCommand = new ExitCommand();
    private AddIfMaxCommand addIfMaxCommand = new AddIfMaxCommand();
    private HeadCommand headCommand = new HeadCommand();
    private RemoveHeadCommand removeHeadCommand = new RemoveHeadCommand();
    private FilterLessThanNumberOfRoomsCommand filterLessThanNumberOfRoomsCommand = new FilterLessThanNumberOfRoomsCommand();
    private ExecuteScriptCommand executeScriptCommand = new ExecuteScriptCommand();

    public CommandManager(){
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


    public void help() {

            for (Command command : commands) {
                System.out.println(command.getName() + " - " +  command.getDescription());
            }
    }
    public boolean executeScript(String argument){
        return executeScriptCommand.findCycles(argument);

    }
    public void info(String argument, Flats flats) {
        infoCommand.execute(argument,flats);
    }

    public void show(String argument, Flats flats) {
        showCommand.execute(argument,flats);
    }


    public void add(String argument, Flats flats) {
         addCommand.execute(argument,flats);
    }

    public void update(String argument, Flats flats) {
         updateCommand.execute(argument,flats);
    }


    public void removeById(String argument, Flats flats) {
        removeByIdCommand.execute(argument,flats);
    }
    public void printUniquePrice(String argument,Flats flats){
        printUniquePrice.execute(argument,flats);
    }

    public void clear(String argument, Flats flats) {
        clearCommand.execute(argument,flats);
    }


    public void save(String argument, Flats flats){
        saveCommand.execute(argument,flats);
    }


    public void exit(String argument, Flats flats) {
         exitCommand.execute(argument,flats);
    }


   // public boolean executeScript(String argument) {
    //    return executeScriptCommand.execute(argument);
   // }


    public void addIfMax(String argument, Flats flats) {
        addIfMaxCommand.execute(argument,flats);
    }


    public void head(String argument, Flats flats) {
        headCommand.execute(argument, flats);
    }

    public void removeHead(String argument, Flats flats) {
        removeHeadCommand.execute(argument, flats);
    }


    public void filterLessThanNumberOfRoomsCommand(String argument, Flats flats) {
        filterLessThanNumberOfRoomsCommand.execute(argument, flats);
    }

    @Override
    public String toString() {
        return "CommandManager - класс для работы с коммандами.";
    }
}