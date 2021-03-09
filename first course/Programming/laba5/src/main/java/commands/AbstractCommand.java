package commands;

import CollectionManager.Flats;
import utils.UserAsker;

/**
 * Класс абстрактной команды содержит основные методы и поля любой команды
 */
public abstract class AbstractCommand implements Command {

    /**
     * Имя команды
     */
    private String name;
    /**
     * Описание команды
     */
    private String description;
    /**
     * Объект для работы с потоками ввода
     */
    protected UserAsker userAsker;
    /**
     * Объект, содержаший коллекцию
     */
    protected Flats flats;

    public AbstractCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public UserAsker getUserAsker() {
        return userAsker;
    }

    public void setUserAsker(UserAsker userAsker) {
        this.userAsker = userAsker;
    }

    public Flats getFlats() {
        return flats;
    }

    public void setFlats(Flats flats) {
        this.flats = flats;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + " (" + description + ")";
    };

    @Override
    public int hashCode() {
        return name.hashCode() + description.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        AbstractCommand other = (AbstractCommand) obj;
        return name.equals(other.name) && description.equals(other.description);
    }
}