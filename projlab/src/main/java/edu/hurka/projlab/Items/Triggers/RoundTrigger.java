package edu.hurka.projlab.Items.Triggers;

import edu.hurka.projlab.Characters.Character;
import edu.hurka.projlab.Items.*;

/**
 * RoundTrigger is a subclass of Trigger that handles interactions related
 * beggining of the round.
 * It triggers actions on items when handled by a character.
 */
public class RoundTrigger extends Trigger {

    /**
     * Constructor to initialize a RoundTrigger with a character.
     * 
     * @param character The character associated with this trigger.
     */
    public RoundTrigger(Character character) {
        super(character); // Calls the constructor of the superclass Trigger
    }

    /**
     * Method to handle interactions with a Beer item.
     * Triggers the action associated with the Beer.
     * 
     * @param b The Beer item to be handled.
     */
    public void handle(Beer b) {
        b.trigger(this); // Triggers the action associated with the Beer
    }
}
