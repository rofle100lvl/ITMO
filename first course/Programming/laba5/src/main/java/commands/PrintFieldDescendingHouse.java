package commands;

import CollectionManager.Flats;

public class PrintFieldDescendingHouse extends AbstractCommand {
    public PrintFieldDescendingHouse(String name, String description) {
        super("print_field_descending_house", "Выводит значения поля house всех элементов в порядке убывания");
    }

    public void update(Flats flats) {

    }

    @Override
    public void execute(String argument, Flats flats) {

    }
}