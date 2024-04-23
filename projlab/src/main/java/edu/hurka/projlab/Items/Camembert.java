package edu.hurka.projlab.Items;

import edu.hurka.projlab.Items.Triggers.*;

/**
 * Camembert is a class representing a camembert item in the game.
 * It extends the Item class.
 */
public class Camembert extends Item {

    /**
     * Constructor to initialize a Camembert with durability and fake status.
     * 
     * @param durability The durability of the camembert .
     * @param isFake     Indicates if the camembert is fake.
     */
    public Camembert(int durability, boolean isFake) {
        super(durability, isFake);
    }

    /**
     * Constructor to initialize a Camembert with a specific fake status and default
     * durability.
     * 
     * @param isFake Indicates if the camembert is fake.
     */
    public Camembert(boolean isFake) {
        super(1, isFake);
    }

    /**
     * Default constructor to initialize a non-fake Camembert with default
     * durability.
     */
    public Camembert() {
        super(1, false);
    }

    /**
     * Method to trigger the action associated with the Camembert.
     * Sets the gas status in the character's location to true and drops the
     * camembert .
     * 
     * @param at The ActionTrigger associated with the action.
     */
    public void trigger(ActionTrigger at) {
        at.getCharacter().getMyLocation().setGassed(true);
        at.getCharacter().dropItem(this, null);
    }
}
