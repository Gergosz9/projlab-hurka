package Java.Items;

import Java.Items.Triggers.*;

public class AirFreshener extends Item {
    public AirFreshener(int durability, boolean isFake) {
        super(durability, isFake);
    }

    public void trigger(ActionTrigger at) {
        at.getCharacter().getMyLocation().setGassed(false);
        at.getCharacter().dropItem(this, null);
    }
}
