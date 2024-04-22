package Java.Items;

import Java.Characters.Character;
import Java.Items.Triggers.ActionTrigger;
import Java.Items.Triggers.GasTrigger;

/*
 * The Rag class represents a Rag item in the game.
 * It extends the Item class.
 */
public class Rag extends Item {
    /**
     * Constructs a new Rag object with a durability of 1.
     */
    public Rag(int durability, boolean isFake) {
        super(durability, isFake);
    }

    /**
     * Uses the Rag item based on the given trigger and source character.
     * If the trigger is ItemTrigger.UseActiveItem, the durability of the Rag
     * decreases by 1,
     * the source character's location is going to be ragged for 4 rounds, and if
     * the durability reaches 0,
     * the source character drops the Rag item.
     * 
     * @param trigger the trigger that activates the use of the item
     * @param source  the character that uses the item
     */
    public void trigger(ActionTrigger gt) {
        /*
         * if (trigger == ItemTrigger.UseActiveItem) {
         * durability--;
         * source.getMyLocation().setRagged(4);
         * if (durability == 0) {
         * source.dropItem(this, null); // pontosítani kell
         * }
         * }
         */
    }

}
