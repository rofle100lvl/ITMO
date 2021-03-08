package commands;

import CollectionManager.Flats;
import startClasses.Flat;
import utils.UserAsker;

import java.sql.SQLOutput;

public class PrintFieldDescendingHouseCommand extends AbstractCommand {
    public PrintFieldDescendingHouseCommand(UserAsker userAsker, Flats flats) {
        super("print_field_descending_house", "Выводит значения поля house всех элементов в порядке убывания");
        setUserAsker(userAsker);
        setFlats(flats);
    }

    @Override
    public boolean execute(String argument) {
        if(flats.getFlats().size()==0){
            System.out.println("Коллекция пуста");
            return true;
        }
        flats.sort();
        for(Flat flat: flats.getFlats()){
            System.out.println(flat.getHouse().toString());
        }
        return true;

    }
}