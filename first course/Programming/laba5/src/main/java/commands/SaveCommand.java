package commands;

import CollectionManager.Flats;
import utils.Parser;
import utils.UserAsker;

public class SaveCommand extends AbstractCommand {
    public SaveCommand(UserAsker userAsker,Flats flats) {

        super("save", "Сохранение коллекции в файл");
        setFlats(flats);
        setUserAsker(userAsker);
    }

    @Override
    public boolean execute(String argument) {
        Parser.convertObjectToXml(flats, argument);
        return true;
    }
}