package Java.Items;

import Java.Items.Triggers.*;
import Java.Characters.*;

public class TVSZ extends Item {

    public TVSZ(int durability, boolean isFake) {
        super(durability, isFake);
    }

    public TVSZ(boolean isFake) {
        super(3, isFake);
    }

    public TVSZ(int durability) {
        super(durability, false);
    }

    public TVSZ() {
        super(3, false);
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
