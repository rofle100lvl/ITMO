package commands;

import CollectionManager.Flats;
import utils.UserAsker;

public class InfoCommand extends AbstractCommand{
    public InfoCommand(UserAsker userAsker,Flats flats)
    {
        super("info", "Выводит информацию о коллекции");
        setFlats(flats);
        setUserAsker(userAsker);
    }

    @Override
    public boolean execute(String argument) {
        flats.getInfo();
        return true;
    }
}
