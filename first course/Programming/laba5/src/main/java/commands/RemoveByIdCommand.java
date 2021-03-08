package commands;

import CollectionManager.Flats;
import utils.UserAsker;

public class RemoveByIdCommand extends AbstractCommand {
    public RemoveByIdCommand(UserAsker userAsker,Flats flats) {
        super("remove_by_id", "Удаляет элемент с заданным id");
        setFlats(flats);
        setUserAsker(userAsker);
    }

    @Override
    public boolean execute(String argument) {
        String []wordsRequest = argument.split(" ");
        for (int i = 1; i < wordsRequest.length; i++) {
            try {
                if (flats.removeId(Long.parseLong(wordsRequest[i])))
                    System.out.printf("Удаление %s прошло успешно\n", wordsRequest[i]);
                else System.out.printf("Квартира с id = %s, не существует\n", wordsRequest[i]);
            } catch (NumberFormatException e) {
                System.out.printf("Неправильный формат ввода. \"%s\" не является Long\n", wordsRequest[i]);
                return false;
            }
        }
        return true;
    }
}