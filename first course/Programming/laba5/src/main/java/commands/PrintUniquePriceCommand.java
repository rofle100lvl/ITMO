package commands;

import CollectionManager.Flats;
import utils.UserAsker;

import javax.jws.soap.SOAPBinding;
import java.util.HashSet;

public class PrintUniquePriceCommand extends AbstractCommand {
    public PrintUniquePriceCommand(UserAsker userAsker,Flats flats) {
        super("print_unique_price", "Выводит уникальные значения поля price всех элементов в коллекции");
        setFlats(flats);
        setUserAsker(userAsker);
    }


    @Override
    public boolean execute(String argument) {
        HashSet<Integer> setOfPrice = new HashSet<Integer>();
        for(int i=0;i<flats.getFlats().size();i++){
            setOfPrice.add(flats.getFlats().get(i).getPrice());
        }
        for(Integer price:setOfPrice){
            System.out.println(price);
        }
        return true;
    }
}