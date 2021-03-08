package commands;

import CollectionManager.Flats;
import utils.UserAsker;

public class ShowCommand extends AbstractCommand {
    public ShowCommand(UserAsker userAsker, Flats flats)
    {
        super("show", "Выводит элементы коллекции");
        setFlats(flats);
        setUserAsker(userAsker);
    }

    public void get_info(Flats flats) {
        flats.show();
    }

    @Override
    public boolean execute(String argument) {
        flats.show();
        return true;

    }
}