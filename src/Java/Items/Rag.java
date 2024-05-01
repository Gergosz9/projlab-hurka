package Java.Items;

import Java.Items.Triggers.*;

/**
 * Rag is a class representing a rag item in the game.
 * It extends the Item class.
 */
public class Rag extends Item {

    /*----------------------------------------------------------------------------------------------------
     * CONSTRUCTORS
     *----------------------------------------------------------------------------------------------------*/

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

    /*----------------------------------------------------------------------------------------------------
     * FUNCTIONS
     *----------------------------------------------------------------------------------------------------*/

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

    /*----------------------------------------------------------------------------------------------------
    * TESTER FUNCTIONS
    *----------------------------------------------------------------------------------------------------*/

    /**
     * Checks if this Rag object is equal to another object.
     * Two Rag objects are considered equal if they have the same type, durability,
     * and fake status.
     * 
     * @param o The object to compare to this Rag.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Rag))
            return false;
        if (!super.equals(o))
            return false;
        return super.equals(o);
    }

}
