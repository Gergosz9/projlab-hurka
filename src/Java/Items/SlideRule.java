package Java.Items;

import Java.Items.Triggers.*;

public class SlideRule extends Item {

    public SlideRule(int durability, boolean isFake) {
        super(durability, isFake);
    }

    public SlideRule(boolean isFake) {
        super(1, isFake);
    }

    public SlideRule() {
        super(1, false);
    }

    public void trigger(WinTrigger wt) {
        // TODO END OF GAME FUNCTION CALL
    }
}
