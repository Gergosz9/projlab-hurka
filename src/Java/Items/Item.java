package Java.Items;

import Java.Items.Triggers.*;

/**
 * Item is an abstract class representing an item in the game.
 */
public abstract class Item {
    protected int durability; // The durability of the item
    boolean isFake; // Indicates if the item is fake

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
}
