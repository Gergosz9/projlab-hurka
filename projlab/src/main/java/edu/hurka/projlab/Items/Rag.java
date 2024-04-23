package edu.hurka.projlab.Items;

import edu.hurka.projlab.Items.Triggers.*;

/**
 * Rag is a class representing a rag item in the game.
 * It extends the Item class.
 */
public class Rag extends Item {

    /**
     * Constructor to initialize a Rag with durability and fake status.
     * 
     * @param durability The durability of the rag.
     * @param isFake     Indicates if the rag is fake.
     */
    public Rag(int durability, boolean isFake) {
        super(durability, isFake);
    }

    /**
     * Constructor to initialize a Rag with a specific fake status and default
     * durability.
     * 
     * @param isFake Indicates if the rag is fake.
     */
    public Rag(boolean isFake) {
        super(1, isFake);
    }

    /**
     * Default constructor to initialize a non-fake Rag with default durability.
     */
    public Rag() {
        super(1, false);
    }

    /**
     * Method to trigger the action associated with the Rag.
     * Sets the ragged status in the character's location.
     * Drops the rag.
     * 
     * @param at The ActionTrigger associated with the action.
     */
    public void trigger(ActionTrigger at) {
        at.getCharacter().getMyLocation().setRagged(4);
        at.getCharacter().dropItem(this, null);
    }

}
