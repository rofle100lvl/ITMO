package commands;

import CollectionManager.Flats;
import utils.UserAsker;

public class RemoveHeadCommand extends AbstractCommand {
    public RemoveHeadCommand(UserAsker userAsker,Flats flats) {

        super("head", "Вывод первого элемента коллекции");
        setUserAsker(userAsker);
        setFlats(flats);
    }

    @Override
    public boolean execute(String argument) {
        if (flats.getFlats().size() > 0) {
            flats.head();
            flats.getFlats().removeFirst();
            return true;
        } else return false;
    }
}