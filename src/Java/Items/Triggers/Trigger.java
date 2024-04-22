package Java.Items.Triggers;

import Java.Characters.Character;
import Java.Items.*;

/**
 * Abstract class representing a trigger that interacts with different types of
 * items.
 */
public abstract class Trigger {
    Character character; // The character associated with this trigger

    /**
     * Constructor to initialize the trigger with a character.
     * 
     * @param character The character associated with this trigger.
     */
    public Trigger(Character character) {
        this.character = character;
    }

    /**
     * Getter method to retrieve the character associated with this trigger.
     * 
     * @return The character associated with this trigger.
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * Setter method to set the character associated with this trigger.
     * 
     * @param character The character to be associated with this trigger.
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    // Methods to handle different types of items

    /**
     * Method to handle generic items.
     * 
     * @param i The item to be handled.
     */
    public void handle(Item i) {
        // Implementation specific to each subclass
    }

    /**
     * Method to handle Transistor items.
     * 
     * @param t The Transistor item to be handled.
     */
    public void handle(Transistor t) {
        // Implementation specific to each subclass
    }

    /**
     * Method to handle Camembert items.
     * 
     * @param c The Camembert item to be handled.
     */
    public void handle(Camembert c) {
        // Implementation specific to each subclass
    }

    /**
     * Method to handle Rag items.
     * 
     * @param r The Rag item to be handled.
     */
    public void handle(Rag r) {
        // Implementation specific to each subclass
    }

    /**
     * Method to handle TVSZ items.
     * 
     * @param t The TVSZ item to be handled.
     */
    public void handle(TVSZ t) {
        // Implementation specific to each subclass
    }

    /**
     * Method to handle Beer items.
     * 
     * @param b The Beer item to be handled.
     */
    public void handle(Beer b) {
        // Implementation specific to each subclass
    }

    /**
     * Method to handle Mask items.
     * 
     * @param m The Mask item to be handled.
     */
    public void handle(Mask m) {
        // Implementation specific to each subclass
    }

    /**
     * Method to handle SlideRule items.
     * 
     * @param s The SlideRule item to be handled.
     */
    public void handle(SlideRule s) {
        // Implementation specific to each subclass
    }

    /**
     * Method to handle AirFreshener items.
     * 
     * @param a The AirFreshener item to be handled.
     */
    public void handle(AirFreshener a) {
        // Implementation specific to each subclass
    }
}
