package commands;

import CollectionManager.Flats;

public class InfoCommand extends AbstractCommand{
    public InfoCommand() {
        super("info", "Выводит информацию о коллекции");
    }

    public void get_info(Flats flats){

    }
    @Override
    public void execute(String argument,Flats flats) {
        flats.getInfo();
    }
}
