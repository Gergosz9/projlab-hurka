package Java.Items;

import Java.Characters.Character;
import Java.Items.Triggers.*;

/*
 * The Camembert class represents a Camembert item in the game.
 * It extends the Item class.
 */
public class Camembert extends Item {
    /**
     * Constructs a new Camembert object with a durability of 1.
     */
    public Camembert(int durability, boolean isFake) {
        super(durability, isFake);
    }

    /**
     * Uses the Camembert item based on the given trigger and source character.
     * If the trigger is ItemTrigger.UseActiveItem, the durability of the Camembert
     * decreases by 1,
     * the source character's location is set to gassed, and if the durability
     * reaches 0,
     * the source character drops the Camembert item.
     * 
     * @param trigger the trigger that activates the use of the item
     * @param source  the character that uses the item
     */
    public void trigger(ActionTrigger at) {
        /*
         * if (trigger == ItemTrigger.UseActiveItem) {
         * durability--;
         * source.getMyLocation().setGassed(true);
         * if (durability == 0) {
         * source.dropItem(this, null); // pontosítani kell
         * }
         * }
         */
    }

}
