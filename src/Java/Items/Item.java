package Java.Items;

import Java.Items.Triggers.*;

import java.util.Objects;

/**
 * Item is an abstract class representing an item in the game.
 */
public abstract class Item {
    protected int durability; // The durability of the item
    boolean isFake; // Indicates if the item is fake
    private final String jsonType;  // Required for the deserialization of the saved Item in json format
                                    // because they are stored in a polymorph list which is not supported by the json format

    /**
     * Constructor to initialize an Item with durability and fake status.
     * 
     * @param durability The durability of the item.
     * @param isFake     Indicates if the item is fake.
     */
    protected Item(int durability, boolean isFake) {
        this.durability = durability;
        this.isFake = isFake;

        this.jsonType = this.getClass().getSimpleName();
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


    /**
     * Gets durability of Item
     * @return durability of Item
     */
    public int getDurability() {
        return durability;
    }

    /**
     * Gets boolean value of isFake
     * @return boolean value of isFake
     */
    public boolean isFake() {
        return isFake;
    }

    /**
     * Compares this Item to another object
     * @param o Compared Object
     * @return boolean true if they are equal, false if they are not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return durability == item.durability && isFake == item.isFake;
    }

    /**
     * Hashcode of Item
     * @return Hashcode of Item
     */
    @Override
    public int hashCode() {
        return Objects.hash(durability, isFake);
    }

    /**
     * toString function of Item
     * @return toString of Item
     */
    @Override
    public String toString() {
        return "name: " + getClass().getSimpleName() + "\n" +
               "\tdurability: " + durability + "\n" +
               "\tfake: " + isFake;

    }
}
