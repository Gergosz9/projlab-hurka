package Java.Items;

import Java.Characters.Character;
import Java.Items.Triggers.*;

/**
 * The SlideRule class represents a sliderule item in the game.
 * It extends the Item class
 */
public class SlideRule extends Item {

    /**
     * Constructs a new SlideRule object with a durability of 1.
     */
    public SlideRule(int durability, boolean isFake) {
        super(durability, isFake);
    }

    /**
     * Uses the SlideRule item based on the given trigger and source character.
     * If the trigger is ItemTrigger.UseActiveItem, the durability of the sliderule
     * decreases by 1,
     * after using it the game ends with the players victory.
     * 
     * @param trigger the trigger that activates the use of the item
     * @param source  the character that uses the item
     */
    public void trigger(WinTrigger wt) {
        /*
         * if(trigger == ItemTrigger.UseActiveItem){
         * durability--;
         * 
         * if(durability == 0){
         * System.out.println("Game ends with the players victory");
         * }
         * }
         */
    }
}
