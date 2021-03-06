package commands;

import CollectionManager.Flats;

public class ShowCommand extends AbstractCommand {
    public ShowCommand() {
        super("show", "Выводит элементы коллекции");
    }

    public void get_info(Flats flats) {
        flats.show();
    }

    @Override
    public void execute(String argument,Flats flats) {
        flats.show();
    }
}