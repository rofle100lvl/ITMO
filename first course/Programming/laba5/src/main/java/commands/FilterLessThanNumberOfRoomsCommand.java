package commands;

import CollectionManager.Flats;

public class FilterLessThanNumberOfRoomsCommand extends AbstractCommand {
    public FilterLessThanNumberOfRoomsCommand() {
        super("filter_less_than_number_of_rooms", "Выводит элементы, значение поля numberOfRooms которых меньше заданного");
    }


    @Override
    public void execute(String argument,Flats flats) {
        String[] wordsRequest = argument.split(" ");
        try {
            Long numberOfRooms = Long.parseLong(wordsRequest[1]);
            for(int i=0;i<flats.getFlats().size();i++){
                if(flats.getFlats().get(i).getNumberOfRooms()<numberOfRooms){
                    System.out.println(flats.getFlats().get(i).toString());
                }
            }
        }
        catch(NumberFormatException e){
            System.out.println("Произошла ошибка при вводе поля. Ожидался Long.");
        }

    }
}