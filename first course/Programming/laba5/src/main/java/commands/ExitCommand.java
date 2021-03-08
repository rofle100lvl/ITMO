package commands;

import CollectionManager.Flats;

public class ExitCommand extends AbstractCommand {
    public ExitCommand() {
        super("exit", "Завершение программы");
    }


    @Override
    public boolean execute(String argument) {
        return true;
    }
}