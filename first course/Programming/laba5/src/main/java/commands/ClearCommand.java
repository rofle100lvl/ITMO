package commands;

import CollectionManager.Flats;

public class ClearCommand extends AbstractCommand {
    public ClearCommand() {
        super("clear", "Очистка коллекции");
    }


    @Override
    public void execute(String argument,Flats flats) {
        flats.clear();
    }
}