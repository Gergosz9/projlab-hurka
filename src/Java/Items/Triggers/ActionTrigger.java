package Java.Items.Triggers;

import Java.Characters.Character;
import Java.Items.*;

/**
 * ActionTrigger is a subclass of Trigger that handles specific item
 * interactions.
 * It triggers actions on items when handled by a character.
 */
public class ActionTrigger extends Trigger {

    /*----------------------------------------------------------------------------------------------------
     * CONSTRUCTORS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Constructor to initialize an ActionTrigger with a character.
     * 
     * @param character The character associated with this trigger.
     */
    public ActionTrigger(Character character) {
        super(character);
    }

    /*----------------------------------------------------------------------------------------------------
     * FUNCTIONS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Method to handle interactions with a Transistor item.
     * Triggers the action associated with the Transistor.
     * 
     * @param t The Transistor item to be handled.
     */
    public void handle(Transistor t) {
        t.trigger(this);
    }

    /**
     * Method to handle interactions with a Camembert item.
     * Triggers the action associated with the Camembert.
     * 
     * @param c The Camembert item to be handled.
     */
    public void handle(Camembert c) {
        c.trigger(this);
    }

    /**
     * Method to handle interactions with a Rag item.
     * Triggers the action associated with the Rag.
     * 
     * @param r The Rag item to be handled.
     */
    public void handle(Rag r) {
        r.trigger(this);
    }

    /**
     * Method to handle interactions with a Beer item.
     * Triggers the action associated with the Beer.
     * 
     * @param b The Beer item to be handled.
     */
    public void handle(Beer b) {
        b.trigger(this);
    }

    /**
     * Method to handle interactions with an AirFreshener item.
     * Triggers the action associated with the AirFreshener.
     * 
     * @param a The AirFreshener item to be handled.
     */
    public void handle(AirFreshener a) {
        a.trigger(this);
    }

}
