package Java.Items;

import java.util.Random;

import Java.Items.Triggers.*;
import Java.Characters.*;
import Java.Items.Triggers.RoundTrigger;

public class Beer extends Item {
    private boolean isInUse = false;

    public Beer(int durability, boolean isFake) {
        super(durability, isFake);
    }

    public Beer(boolean isFake) {
        super(5, isFake);
    }

    public Beer(int durability) {
        super(durability, false);
    }

    public Beer() {
        super(5, false);
    }

    public void trigger(RoundTrigger rt) {
        if (isInUse) {
            Student student = (Student) rt.getCharacter();
            student.setTeacherResist(true);

            durability -= 1;
        }
    }

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
}
