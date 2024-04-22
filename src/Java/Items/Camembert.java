package Java.Items;

import Java.Items.Triggers.*;

public class Camembert extends Item {

    public Camembert(int durability, boolean isFake) {
        super(durability, isFake);
    }

    public void trigger(ActionTrigger at) {
        at.getCharacter().getMyLocation().setGassed(true);
        at.getCharacter().dropItem(this, null);
    }

}
