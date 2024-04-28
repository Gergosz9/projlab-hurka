package Java.Items;

import java.util.Objects;
import java.util.Random;

import Java.Items.Triggers.*;
import Java.Characters.*;

/**
 * Beer is a class representing a beer item in the game.
 * It extends the Item class.
 */
public class Beer extends Item {
    private boolean isInUse = false; // Indicates if the beer is currently in use

    /**
     * Constructor to initialize a Beer with durability and fake status.
     * 
     * @param durability The durability of the beer.
     * @param isFake     Indicates if the beer is fake.
     */
    public Beer(int durability, boolean isFake) {
        super(durability, isFake);
    }

    /**
     * Constructor to initialize a Beer with a specific fake status and default
     * durability.
     * 
     * @param isFake Indicates if the beer is fake.
     */
    public Beer(boolean isFake) {
        super(5, isFake);
    }

    /**
     * Constructor to initialize a Beer with a specific durability and non-fake
     * status.
     * 
     * @param durability The durability of the beer.
     */
    public Beer(int durability) {
        super(durability, false);
    }

    /**
     * Default constructor to initialize a non-fake Beer with default durability.
     */
    public Beer() {
        super(5, false);
    }

    /**
     * Method to trigger the action associated with the Beer when used with a
     * RoundTrigger.
     * Grants resistance against teachers for the student character using the beer.
     * Decreases durability of the beer.
     * 
     * @param rt The RoundTrigger associated with the action.
     */
    public void trigger(RoundTrigger rt) {
        if (isInUse) {
            Student student = (Student) rt.getCharacter();
            student.setTeacherResist(true);
            durability -= 1;
        }
    }

    /**
     * Method to trigger the action associated with the Beer when used with an
     * ActionTrigger.
     * Grants resistance against teachers for the student character using the beer
     * if
     * not already in use.
     * Otherwise, randomly drops an item from the character's inventory.
     * Decreases durability of the beer.
     * 
     * @param at The ActionTrigger associated with the action.
     */
    public void trigger(ActionTrigger at) {
        if (!isInUse) {
            isInUse = true;
            Student student = (Student) at.getCharacter();
            student.setTeacherResist(true);
            durability -= 1;
        } else {
            Random random = new Random();
            int randomidx = random.nextInt(0, at.getCharacter().getInventory().size());
            Item randomitem = at.getCharacter().getInventory().get(randomidx);
            at.getCharacter().dropItem(randomitem, at.getCharacter().getMyLocation());
        }
    }

    /**
     * Checks if this Beer object is equal to another object.
     * Two Beer objects are considered equal if they have the same type, durability,
     * fake status, and isInUse status.
     * 
     * @param o The object to compare to this Beer.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Beer beer))
            return false;

        if (!super.equals(o))
            return false;

        return isInUse == beer.isInUse;
    }

    /**
     * Generates a hash code value for the Beer object.
     * The hash code is computed based on the hash codes of superclass fields and
     * the
     * isInUse field.
     * 
     * @return A hash code value for this Beer object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isInUse);
    }

}
