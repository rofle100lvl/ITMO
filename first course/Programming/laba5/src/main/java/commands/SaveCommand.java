package commands;

import CollectionManager.Flats;
import utils.Parser;

public class SaveCommand extends AbstractCommand {
    public SaveCommand() {
        super("save", "Сохранение коллекции в файл");
    }

    public void get_info(Flats flats) {
        flats.clear();
    }

    @Override
    public void execute(String argument,Flats flats) {
        Parser.convertObjectToXml(flats, argument);
    }
}