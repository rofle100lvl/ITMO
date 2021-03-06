package commands;

import CollectionManager.Flats;

/**
 * Interface for all commands.
 */
public interface Command {
    String getDescription();
    String getName();
    void execute(String argument, Flats flats);
}