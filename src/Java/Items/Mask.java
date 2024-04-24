package Java.Items;

import Java.Items.Triggers.*;

/**
 * Mask is a class representing a mask item in the game.
 * It extends the Item class.
 */
public class Mask extends Item {

    /**
     * Constructor to initialize a Mask with durability and fake status.
     * 
     * @param durability The durability of the mask.
     * @param isFake     Indicates if the mask is fake.
     */
    public Mask(int durability, boolean isFake) {
        super(durability, isFake);
    }

    /**
     * Constructor to initialize a Mask with a specific fake status and default
     * durability.
     * 
     * @param isFake Indicates if the mask is fake.
     */
    public Mask(boolean isFake) {
        super(5, isFake);
    }

    /**
     * Constructor to initialize a Mask with a specific durability and non-fake
     * status.
     * 
     * @param durability The durability of the mask.
     */
    public Mask(int durability) {
        super(durability, false);
    }

    /**
     * Default constructor to initialize a non-fake Mask with default durability.
     */
    public Mask() {
        super(5, false);
    }

    /**
     * Method to trigger the action associated with the Mask when used with a
     * GasTrigger.
     * Grants gas resistance to the character if the character's location is gassed.
     * Decreases durability of the mask.
     * Drops the mask if durability reaches zero.
     * 
     * @param gt The GasTrigger associated with the action.
     */
    public void trigger(GasTrigger gt) {
        if (gt.getCharacter().getMyLocation().isGassed()) {
            this.durability -= 1;
            gt.getCharacter().setGasResist(true);
        }
        if (this.durability <= 0) {
            gt.getCharacter().dropItem(this, null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mask mask)) return false;
        if (!super.equals(o)) return false;
        return super.equals(o);
    }
}
