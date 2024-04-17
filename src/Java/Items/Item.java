package Java.Items;

import Java.Items.Triggers.*;

/**
 * The abstract class Item represents an item in the game.
 * It provides a common structure and behavior for all items.
 * @param durability the durability of the item
 */
public abstract class Item {
    protected int durability;
    boolean  isFake;

    /**
     * Constructs an Item object with the specified durability.
     * 
     * @param durability the durability of the item
     */
    public Item(int durability, boolean fakeness){
        this.durability = durability;
        this.isFake = fakeness;
    }

    /**
     * Uses the item with the given trigger and source character.
     * This method should be implemented by subclasses.
     * 
     * @param trigger the trigger for using the item
     * @param source the character using the item
     */
    public abstract void use(Trigger trigger); 
}