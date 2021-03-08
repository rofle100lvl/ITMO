package commands;

import CollectionManager.Flats;
import startClasses.Flat;
import utils.UserAsker;

public class HeadCommand extends AbstractCommand {
    public HeadCommand(UserAsker userAsker,Flats flats) {
        super("head", "Вывод первого элемента коллекции");
        setUserAsker(userAsker);
        setFlats(flats);
    }

    @Override
    public boolean execute(String argument) {
        flats.head();
        return true;
    }
}