package commands;

import CollectionManager.Flats;

public class RemoveHeadCommand extends AbstractCommand {
    public RemoveHeadCommand() {
        super("head", "Вывод первого элемента коллекции");
    }

    public void get_info(Flats flats) {
        flats.clear();
    }

    @Override
    public void execute(String argument, Flats flats) {

    }
}