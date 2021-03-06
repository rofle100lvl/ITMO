package commands;

import CollectionManager.Flats;
import startClasses.Flat;

public class HeadCommand extends AbstractCommand {
    public HeadCommand() {
        super("head", "Вывод первого элемента коллекции");
    }

    public void get_info(Flats flats) {
        flats.clear();
    }

    @Override
    public void execute(String argument, Flats flats) {
        flats.head();
    }
}