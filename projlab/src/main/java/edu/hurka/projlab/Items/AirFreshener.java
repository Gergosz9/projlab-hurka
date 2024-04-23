package edu.hurka.projlab.Items;

import edu.hurka.projlab.Items.Triggers.*;

/**
 * AirFreshener is a class representing an air freshener item in the game.
 * It extends the Item class.
 */
public class AirFreshener extends Item {

    /**
     * Constructor to initialize an AirFreshener with durability and fake status.
     * 
     * @param durability The durability of the air freshener.
     * @param isFake     Indicates if the air freshener is fake.
     */
    public AirFreshener(int durability, boolean isFake) {
        super(durability, isFake);
    }

    /**
     * Constructor to initialize an AirFreshener with a specific fake status and
     * default durability.
     * 
     * @param isFake Indicates if the air freshener is fake.
     */
    public AirFreshener(boolean isFake) {
        super(1, isFake);
    }

    /**
     * Default constructor to initialize a non-fake AirFreshener with default
     * durability.
     */
    public AirFreshener() {
        super(1, false);
    }

    /**
     * Method to trigger the action associated with the AirFreshener.
     * Clears the gas status in the character's location and drops the air
     * freshener.
     * 
     * @param at The ActionTrigger associated with the action.
     */
    public void trigger(ActionTrigger at) {
        at.getCharacter().getMyLocation().setGassed(false);
        at.getCharacter().dropItem(this, null);
    }
}
