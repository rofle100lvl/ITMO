package commands;

import CollectionManager.Flats;

import java.util.HashSet;

public class PrintUniquePriceCommand extends AbstractCommand {
    public PrintUniquePriceCommand() {
        super("print_unique_price", "Выводит уникальные значения поля price всех элементов в коллекции");
    }


    @Override
    public void execute(String argument, Flats flats) {
        HashSet<Integer> setOfPrice = new HashSet<Integer>();
        for(int i=0;i<flats.getFlats().size();i++){
            setOfPrice.add(flats.getFlats().get(i).getPrice());
        }
        for(Integer price:setOfPrice){
            System.out.println(price);
        }
    }
}