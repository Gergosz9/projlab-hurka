package Java.Items;

import Java.ItemTrigger;
import Java.Characters.Character;
import Java.Characters.Student;

/**
 * The Beer class represents a beer item in the game.
 * It extends the Item class
 */
public class Beer extends Item{
    /**
     * Constructs a new Beer object with the specified durability.
     * 
     * @param durability the durability of the beer
     */
    public Beer(int durability){
        super(durability);
    }
    
    /**
     * Uses the beer item based on the given trigger and source character.
     * If the trigger is NewRound, the durability of the beer decreases by 1,
     * the source character's teacher resist attribute is set to true,
     * and if the durability reaches 0, the source character drops the beer.
     * 
     * @param trigger the trigger that activates the use of the beer
     * @param source the character using the beer
     */
    public void use(ItemTrigger trigger, Character source){
        Student student = (Student)source;
        if(trigger == ItemTrigger.NewRound){
            durability--;
            student.setTeacherResist(true);
            if(durability == 0){
                source.dropItem(this, null);
            }
        }
    }
}
