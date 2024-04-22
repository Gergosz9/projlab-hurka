package Java.Items;

import Java.Items.Triggers.AttackTrigger;

public class TVSZ extends Item {

    public TVSZ(int durability, boolean isFake) {
        super(durability, isFake);
    }

    public void trigger(AttackTrigger at) {
        /*
         * Student student = (Student) source;
         * if (trigger == ItemTrigger.TeacherAttack) {
         * durability--;
         * student.setTeacherResist(true);
         * if (durability == 0) {
         * source.dropItem(this, null); // pontos�tani kell
         * }
         * }
         */
    }
}
