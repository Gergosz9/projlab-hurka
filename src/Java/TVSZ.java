package Java;

/**
 * The TVSZ class represents a TVSZ item in the game.
 * It extends the Item class
 */
public class TVSZ extends Item{
    
    /**
     * Constructs a new TVSZ object with the specified durability.
     * 
     * @param durability the durability of the TVSZ
     */
    public TVSZ(int durability){
        super(durability);
    }

    /**
     * Uses the TVSZ item based on the given trigger and source character.
     * If the trigger is TeacherAttack, the durability of the TVSZ decreases by 1,
     * the source character's teacher resist attribute is set to true,
     * and if the durability reaches 0, the source character drops the TVSZ.
     * 
     * @param trigger the trigger that activates the use of the TVSZ
     * @param source the character using the TVSZ
     */
    public void use(ItemTrigger trigger, Character source){
        Student student = (Student)source;
        if(trigger == ItemTrigger.TeacherAttack){
            durability--;
            student.setTeacherResist(true);
            if(durability == 0){
                source.dropItem(this, null); //pontos�tani kell
            }
        }
    }
}
