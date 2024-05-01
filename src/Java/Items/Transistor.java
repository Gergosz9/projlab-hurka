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

    private String jsonId; // Id to load pair from json

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
        super(-1, isFake);
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
        super(-1, false);
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

    /**
     * Gets the labyrinth in which the transistor exists.
     * 
     * @return The labyrinth.
     */
    public Labirinth getLabirinth() {
        return labirinth;
    }

    /**
     * Sets the labyrinth in which the transistor exists.
     * 
     * @param labirinth The labyrinth to set.
     */
    public void setLabirinth(Labirinth labirinth) {
        this.labirinth = labirinth;
    }

    /**
     * Sets the pair for the transistor
     *
     * @param pair the paired transostor
     */
    public void setPair(Transistor pair) {
        this.pair = pair;
    }

    /**
     * returns the pair to this transistor
     *
     * @return the pair to this transistor
     */
    public Transistor getPair() {
        return pair;
    }

    /**
     * returns the jsonId of the transistor. Only used in saving a nd loading the
     * project
     *
     * @return the jsonId of the transistor
     */
    public String getJsonId() {
        return jsonId;
    }

    /**
     * Sets the jsonId of the Transistor. Only used in saving a nd loading the
     * project
     *
     * @param jsonId the id
     */
    public void setJsonId(String jsonId) {
        this.jsonId = jsonId;
    }

    /**
     * Checks if this Transistor object is equal to another object.
     * Two Transistor objects are considered equal if they have the same type,
     * durability,
     * and paired transistor.
     * 
     * @param o The object to compare to this Transistor.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Transistor))
            return false;
        return durability == ((Transistor) o).getDurability() && isFake == ((Transistor) o).isFake();
    }

    /**
     * Generates a hash code value for the Transistor object.
     * The hash code is computed based on the hash codes of superclass fields and
     * the
     * paired transistor.
     * 
     * @return A hash code value for this Transistor object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pair);
    }
}
