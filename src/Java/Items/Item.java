package Java.Items;

import Java.Items.Triggers.*;

import java.util.Objects;

/**
 * Item is an abstract class representing an item in the game.
 */
public abstract class Item {
    protected int durability; // The durability of the item
    boolean isFake; // Indicates if the item is fake

    /*----------------------------------------------------------------------------------------------------
     * CONSTRUCTORS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Constructor to initialize an Item with durability and fake status.
     * 
     * @param durability The durability of the item.
     * @param isFake     Indicates if the item is fake.
     */
    protected Item(int durability, boolean isFake) {
        this.durability = durability;
        this.isFake = isFake;
    }

    /*----------------------------------------------------------------------------------------------------
     * FUNCTIONS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Method to use the item with a given trigger.
     * If the item is not fake, it triggers the handle method of the trigger with
     * itself.
     * If the item is fake, it drops the item from the character's inventory.
     * 
     * @param trigger The trigger to use the item with.
     */
    public void use(Trigger trigger) {
        if (!this.isFake) {
            trigger.handle(this);
        } else {
            trigger.getCharacter().dropItem(this, null);
        }
    }

    /*----------------------------------------------------------------------------------------------------
     * GETTERS AND SETTERS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Getter for the durability of the item.
     *
     * @return The durability of the item.
     */
    public int getDurability() {
        return durability;
    }

    /**
     * Setter for the durability of the item.
     *
     * @param durability The durability of the item.
     */
    public void setDurability(int durability) {
        this.durability = durability;
    }

    /**
     * Getter for the fake status of the item.
     *
     * @return True if the item is fake, false otherwise.
     */
    public boolean isFake() {
        return isFake;
    }

    /**
     * Setter for the fake status of the item.
     *
     * @param fake True if the item is fake, false otherwise.
     */
    public void setFake(boolean fake) {
        isFake = fake;
    }

    /*----------------------------------------------------------------------------------------------------
    * TESTER FUNCTIONS
    *----------------------------------------------------------------------------------------------------*/

    /**
     * Compares this Item to another object
     * 
     * @param o Compared Object
     * @return boolean true if they are equal, false if they are not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Item item))
            return false;
        return durability == item.durability && isFake == item.isFake;
    }
}
