package commands;

import CollectionManager.Flats;
import utils.UserAsker;

/**
 * Abstract Command class contains Object methods, name and description.
 */
public abstract class AbstractCommand implements Command {
    private String name;
    private String description;
    protected UserAsker userAsker;
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