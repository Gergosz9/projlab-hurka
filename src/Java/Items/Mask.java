package Java.Items;

import Java.Characters.Character;
import Java.Items.Triggers.*;

/*
 * The Mask class represents a mask item in the game.
 * It extends the Item class.
 */
public class Mask extends Item {

    /**
     * Constructs a new Mask object with a durability of 3.
     */
    public Mask(int durability, boolean isFake) {
        super(durability, isFake);
    }

    /**
     * Uses the Mask item based on the given trigger and source character.
     * If the trigger is ItemTrigger.GasAttack, the durability of the mask decreases
     * by 1,
     * the source character's gas resist attribute is set to true,
     * and if the durability reaches 0, the source character drops the mask.
     * 
     * @param trigger the trigger that activates the use of the item
     * @param source  the character that uses the item
     */
    public void trigger(GasTrigger gt) {
        /*
         * if(trigger == ItemTrigger.GasAttack){
         * durability--;
         * source.setGasResist(true);
         * if(durability == 0){
         * source.dropItem(this, null);
         * }
         * }
         */
    }
}
