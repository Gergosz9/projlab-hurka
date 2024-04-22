package Java.Items.Triggers;

import Java.Characters.Character;
import Java.Items.*;

/**
 * WinTrigger is a subclass of Trigger that handles interactions related to
 * winning conditions.
 * It triggers actions on items when handled by a character.
 */
public class WinTrigger extends Trigger {

    /**
     * Constructor to initialize a WinTrigger with a character.
     * 
     * @param character The character associated with this trigger.
     */
    public WinTrigger(Character character) {
        super(character);
    }

    /**
     * Method to handle interactions with a SlideRule item.
     * Triggers the action associated with the SlideRule.
     * 
     * @param s The SlideRule item to be handled.
     */
    public void handle(SlideRule s) {
        s.trigger(this);
    }
}
