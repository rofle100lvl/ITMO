package commands;

import CollectionManager.Flats;
import utils.UserAsker;

import javax.jws.soap.SOAPBinding;
import java.util.HashSet;

/**
 * Класс команды, выводящей уникальные значения поля price всех элементов в коллекции
 */
public class PrintUniquePriceCommand extends AbstractCommand {
    public PrintUniquePriceCommand(UserAsker userAsker,Flats flats) {
        super("print_unique_price", "Выводит уникальные значения поля price всех элементов в коллекции");
        setFlats(flats);
        setUserAsker(userAsker);
    }

    /**
     * Метод запускающий команду
     * @param argument Запрос пользователя
     * @return Возвращает true, если команда обработана
     */
    @Override
    public boolean execute(String argument) {
        if(flats.getFlats().size()==0){
            System.out.println("Коллекция пуста");
            return true;
        }
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