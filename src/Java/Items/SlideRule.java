package Java.Items;

import Java.Items.Triggers.*;

/**
 * SlideRule is a class representing a slide rule item in the game.
 * It extends the Item class.
 */
public class SlideRule extends Item {

    /*----------------------------------------------------------------------------------------------------
     * CONSTRUCTORS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Constructor to initialize a SlideRule with durability and fake status.
     * 
     * @param durability The durability of the slide rule.
     * @param isFake     Indicates if the slide rule is fake.
     */
    public SlideRule(int durability, boolean isFake) {
        super(durability, isFake);
    }

    /**
     * Constructor to initialize a SlideRule with a specific fake status and default
     * durability.
     * 
     * @param isFake Indicates if the slide rule is fake.
     */
    public SlideRule(boolean isFake) {
        super(1, isFake);
    }

    /**
     * Default constructor to initialize a non-fake SlideRule with default
     * durability.
     */
    public SlideRule() {
        super(1, false);
    }

    /*----------------------------------------------------------------------------------------------------
     * FUNCTIONS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Method to trigger the action associated with the SlideRule when used with a
     * WinTrigger.
     * This method implements the end-of-game function call.
     * 
     * @param wt The WinTrigger associated with the action.
     */
    public void trigger(WinTrigger wt) {
        // TODO: Implement end-of-game function call
    }

    /*----------------------------------------------------------------------------------------------------
    * TESTER FUNCTIONS
    *----------------------------------------------------------------------------------------------------*/

    /**
     * Checks if this SlideRule object is equal to another object.
     * Two SlideRule objects are considered equal if they have the same type,
     * durability,
     * and fake status.
     * 
     * @param o The object to compare to this SlideRule.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SlideRule))
            return false;
        if (!super.equals(o))
            return false;
        return super.equals(o);
    }

}
