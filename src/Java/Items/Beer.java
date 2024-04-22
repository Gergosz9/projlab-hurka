package Java.Items;

import Java.Items.Triggers.*;
import Java.Items.Triggers.RoundTrigger;

public class Beer extends Item {
    public Beer(int durability, boolean isFake) {
        super(durability, isFake);
    }

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
