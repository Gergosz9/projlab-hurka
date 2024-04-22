package Java.Items;

import Java.Items.Triggers.*;

public class Camembert extends Item {

    public Camembert(int durability, boolean isFake) {
        super(durability, isFake);
    }

    public Camembert(boolean isFake) {
        super(1, isFake);
    }

    public Camembert() {
        super(1, false);
    }

    public void trigger(ActionTrigger at) {
        at.getCharacter().getMyLocation().setGassed(true);
        at.getCharacter().dropItem(this, null);
    }

}
