package commands;

import CollectionManager.Flats;

public class ExitCommand extends AbstractCommand {
    public ExitCommand() {
        super("exit", "Завершение программы");
    }

    public void get_info(Flats flats) {
        flats.clear();
    }

    @Override
    public void execute(String argument, Flats flats) {

    }
}