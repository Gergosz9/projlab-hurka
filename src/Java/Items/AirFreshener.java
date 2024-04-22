package Java.Items;

import Java.Items.Triggers.*;

public class AirFreshener extends Item {
    public AirFreshener(int durability, boolean isFake) {
        super(durability, isFake);
    }

    public AirFreshener(boolean isFake) {
        super(1, isFake);
    }

    public AirFreshener() {
        super(1, false);
    }

    public void trigger(ActionTrigger at) {
        at.getCharacter().getMyLocation().setGassed(false);
        at.getCharacter().dropItem(this, null);
    }
}
