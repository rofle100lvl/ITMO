package commands;

import CollectionManager.Flats;

public class RemoveByIdCommand extends AbstractCommand {
    public RemoveByIdCommand() {
        super("remove_by_id", "Удаляет элемент с заданным id");
    }

    @Override
    public void execute(String argument, Flats flats) {
        String []wordsRequest = argument.split(" ");
        for (int i = 1; i < wordsRequest.length; i++) {
            try {
                if (flats.removeId(Long.parseLong(wordsRequest[i])))
                    System.out.printf("Удаление %s прошло успешно\n", wordsRequest[i]);
                else System.out.printf("Квартира с id = %s, не существует\n", wordsRequest[i]);
            } catch (NumberFormatException e) {
                System.out.printf("Неправильный формат ввода. \"%s\" не является Long\n", wordsRequest[i]);
            }
        }
    }
}