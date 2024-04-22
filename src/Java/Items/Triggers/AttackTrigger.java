package Java.Items.Triggers;

import Java.Characters.Character;
import Java.Items.*;

/**
 * AttackTrigger is a subclass of Trigger that handles attacks on specific
 * items.
 * It triggers attacks on items when handled by a character.
 */
public class AttackTrigger extends Trigger {

    /**
     * Constructor to initialize an AttackTrigger with a character.
     * 
     * @param character The character associated with this trigger.
     */
    public AttackTrigger(Character character) {
        super(character);
    }

    /**
     * Method to handle interactions with a TVSZ.
     * Triggers the attack associated with the TVSZ.
     * 
     * @param t The TVSZ item to be handled.
     */
    public void handle(TVSZ t) {
        t.trigger(this);
    }
}
