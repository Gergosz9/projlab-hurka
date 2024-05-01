package Java.Items;

import org.json.JSONObject;

import Java.Labirinth;
import Java.Room;
import Java.Items.Triggers.*;

/**
 * Transistor is a class representing a transistor item in the game.
 * It extends the Item class.
 */
public class Transistor extends Item {
    private Labirinth labirinth; // The labyrinth in which the transistor exists
    private Transistor pair; // The paired transistor

    /*----------------------------------------------------------------------------------------------------
     * CONSTRUCTORS
     *----------------------------------------------------------------------------------------------------*/

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

    /*----------------------------------------------------------------------------------------------------
     * FUNCTIONS
     *----------------------------------------------------------------------------------------------------*/

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
            if (room.getItems().contains(pair)) {
                return room;
            }
        }
        return null;
    }

    /*----------------------------------------------------------------------------------------------------
     * GETTERS AND SETTERS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Getter for the labirinth variable.
     * 
     * @return The labirinth variable.
     */
    public Labirinth getLabirinth() {
        return labirinth;
    }

    /**
     * Setter for the labirinth variable.
     * 
     * @param labirinth The labirinth variable to set.
     */
    public void setLabirinth(Labirinth labirinth) {
        this.labirinth = labirinth;
    }

    /**
     * Getter for the pair variable.
     * 
     * @return The pair variable.
     */
    public Transistor getPair() {
        return pair;
    }

    /**
     * Setter for the pair variable.
     * 
     * @param pair The pair variable to set.
     */
    public void setPair(Transistor pair) {
        this.pair = pair;
    }

    /*----------------------------------------------------------------------------------------------------
    * TESTER FUNCTIONS
    *----------------------------------------------------------------------------------------------------*/

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
     * Converts the Transistor object to a JSON representation
     *
     * @return The JSON representation of the Transistor object
     */
    public JSONObject toJSON() {
        boolean paired = pair != null;

        JSONObject json = new JSONObject();
        json.put("type", this.getClass().getSimpleName());
        json.put("durability", durability);
        json.put("isFake", isFake);
        json.put("paired", paired);
        return json;
    }
}
