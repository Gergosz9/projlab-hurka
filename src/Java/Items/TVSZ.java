package Java.Items;

import Java.Items.Triggers.*;
import Java.Characters.*;

public class TVSZ extends Item {

    public TVSZ(int durability, boolean isFake) {
        super(durability, isFake);
    }

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
}
