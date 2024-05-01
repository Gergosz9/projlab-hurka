package Java.Items;

import Java.Items.Triggers.*;
import Java.Characters.*;

/**
 * TVSZ is a class representing a TVSZ (Television Broadcasting Transmitter)
 * item in the game.
 * It extends the Item.
 */
public class TVSZ extends Item {

    /*----------------------------------------------------------------------------------------------------
     * CONSTRUCTORS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Constructor to initialize a TVSZ with durability and fake status.
     * 
     * @param durability The durability of the TVSZ.
     * @param isFake     Indicates if the TVSZ is fake.
     */
    public TVSZ(int durability, boolean isFake) {
        super(durability, isFake);
    }

    /**
     * Constructor to initialize a TVSZ with a specific fake status and default
     * durability.
     * 
     * @param isFake Indicates if the TVSZ is fake.
     */
    public TVSZ(boolean isFake) {
        super(3, isFake);
    }

    /**
     * Constructor to initialize a TVSZ with a specific durability and non-fake
     * status.
     * 
     * @param durability The durability of the TVSZ.
     */
    public TVSZ(int durability) {
        super(durability, false);
    }

    /**
     * Default constructor to initialize a non-fake TVSZ with default durability.
     */
    public TVSZ() {
        super(3, false);
    }

    /*----------------------------------------------------------------------------------------------------
     * FUNCTIONS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Method to trigger the action associated with the TVSZ when used with an
     * AttackTrigger.
     * Grants resistance against teachers for the student character using the TVSZ.
     * Decreases durability of the TVSZ.
     * Drops the TVSZ if durability reaches zero.
     * 
     * @param at The AttackTrigger associated with the action.
     */
    public void trigger(AttackTrigger at) {
        Student student = (Student) at.getCharacter();
        if (!student.getTeacherResist()) {
            student.setTeacherResist(true);
            this.durability -= 1;
        }

        if (this.durability <= 0) {
            student.dropItem(this, null);
        }
    }

    /*----------------------------------------------------------------------------------------------------
    * TESTER FUNCTIONS
    *----------------------------------------------------------------------------------------------------*/

    /**
     * Checks if this TVSZ object is equal to another object.
     * Two TVSZ objects are considered equal if they have the same type, durability,
     * and fake status.
     * 
     * @param o The object to compare to this TVSZ.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof TVSZ))
            return false;
        if (!super.equals(o))
            return false;
        return super.equals(o);
    }

}
