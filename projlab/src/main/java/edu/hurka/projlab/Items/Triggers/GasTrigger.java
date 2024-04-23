package edu.hurka.projlab.Items.Triggers;

import edu.hurka.projlab.Characters.Character;
import edu.hurka.projlab.Items.*;

/**
 * GasTrigger is a subclass of Trigger that handles gas-related interactions.
 * It triggers actions on items when handled by a character.
 */
public class GasTrigger extends Trigger {

    /**
     * Constructor to initialize a GasTrigger with a character.
     * 
     * @param character The character associated with this trigger.
     */
    public GasTrigger(Character character) {
        super(character); // Calls the constructor of the superclass Trigger
    }

    /**
     * Method to handle interactions with a Mask item.
     * Triggers the action associated with the Mask
     * 
     * @param m The Mask item to be handled.
     */
    public void handle(Mask m) {
        m.trigger(this); // Triggers the action associated with the Mask
    }
}
