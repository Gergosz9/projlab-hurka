package Java.Items;

import Java.Labirinth;
import Java.Room;
import Java.Items.Triggers.*;

import java.util.Objects;

/**
 * Transistor is a class representing a transistor item in the game.
 * It extends the Item class.
 */
public class Transistor extends Item {
    private Labirinth labirinth; // The labyrinth in which the transistor exists
    private Transistor pair; // The paired transistor

    public void setLabirinth(Labirinth labirinth) {
        this.labirinth = labirinth;
    }

    /**
     * Constructor to initialize a Transistor with durability, fake status, and
     * labyrinth.
     * 
     * @param durability The durability of the transistor.
     * @param isFake     Indicates if the transistor is fake.
     * @param labirinth  The labyrinth in which the transistor exists.
     */
    public Transistor(int durability, boolean isFake, Labirinth labirinth) {
        super(durability, isFake);
        pair = null;
        this.labirinth = labirinth;
    }

    /**
     * Constructor to initialize a Transistor with a specific fake status, default
     * durability, and labyrinth.
     * 
     * @param isFake    Indicates if the transistor is fake.
     * @param labirinth The labyrinth in which the transistor exists.
     */
    public Transistor(boolean isFake, Labirinth labirinth) {
        super(1, isFake);
        pair = null;
        this.labirinth = labirinth;
    }

    /**
     * Constructor to initialize a Transistor with default durability, non-fake
     * status, and labyrinth.
     * 
     * @param labirinth The labyrinth in which the transistor exists.
     */
    public Transistor(Labirinth labirinth) {
        super(1, false);
        pair = null;
        this.labirinth = labirinth;
    }

    /**
     * Method to trigger the action associated with the Transistor when used with an
     * ActionTrigger.
     * Moves the character to the location of the paired transistor if it exists.
     * Otherwise, attempts to pair the transistor with another in the character's
     * inventory.
     * 
     * @param at The ActionTrigger associated with the action.
     */
    public void trigger(ActionTrigger at) {
        if (pair != null) {
            if (getMyPairLocation() != null)
                at.getCharacter().move(getMyPairLocation());
        } else {
            for (Item i : at.getCharacter().getInventory()) {
                if (i instanceof Transistor) {
                    Transistor t = (Transistor) i;
                    if (t.pair(this)) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Method to pair this transistor with another transistor.
     * 
     * @param pair The transistor to pair with.
     * @return true if pairing is successful, false otherwise.
     */
    private boolean pair(Transistor pair) {
        if (this.pair == null && pair.pair == null) {
            this.pair = pair;
            pair.pair = this;
            return true;
        }
        return false;
    }

    /**
     * Method to get the location of the paired transistor.
     * 
     * @return The room containing the paired transistor, or null if not found.
     */
    private Room getMyPairLocation() {
        for (Room room : labirinth.getRooms()) {
            if (room.getTransistors().contains(pair)) {
                return room;
            }
        }
        return null;
    }

    @Override
    public void use(Trigger trigger) {

    }

    public Labirinth getLabirinth() {
        return labirinth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transistor that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(pair, that.pair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pair);
    }
}
