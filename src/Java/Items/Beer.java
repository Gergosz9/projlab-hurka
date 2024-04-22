package Java.Items;

import Java.Items.Triggers.*;
import Java.Characters.Character;
import Java.Characters.Student;
import Java.Items.Triggers.RoundTrigger;

/**
 * The Beer class represents a beer item in the game.
 * It extends the Item class
 */
public class Beer extends Item {
    /**
     * Constructs a new Beer object with the specified durability.
     * 
     * @param durability the durability of the beer
     */
    public Beer(int durability, boolean isFake) {
        super(durability, isFake);
    }

    /**
     * Uses the beer item based on the given trigger and source character.
     * If the trigger is NewRound, the durability of the beer decreases by 1,
     * the source character's teacher resist attribute is set to true,
     * and if the durability reaches 0, the source character drops the beer.
     * 
     * @param trigger the trigger that activates the use of the beer
     * @param source  the character using the beer
     */
    public void trigger(RoundTrigger rt) {
        // RT implement

        /*
         * Student student = rt.getCharacter();
         * if (trigger == ItemTrigger.NewRound) {
         * durability--;
         * student.setTeacherResist(true);
         * if (durability == 0) {
         * source.dropItem(this, null);
         * }
         * }
         * 
         */
    }

    public void trigger(ActionTrigger at) {
        // AT impelment
    }
}
