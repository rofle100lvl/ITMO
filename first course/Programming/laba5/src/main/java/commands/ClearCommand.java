package commands;

import CollectionManager.Flats;
import utils.UserAsker;

public class ClearCommand extends AbstractCommand {
    public ClearCommand(UserAsker userAsker, Flats flats)
    {
        super("clear", "Очистка коллекции");
        setFlats(flats);
        setUserAsker(userAsker);
    }


    @Override
    public boolean execute(String argument) {
        return flats.clear();
    }
}