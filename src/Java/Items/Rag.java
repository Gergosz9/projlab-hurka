package Java.Items;

import Java.Items.Triggers.*;

public class Rag extends Item {

    public Rag(int durability, boolean isFake) {
        super(durability, isFake);
    }

    public void trigger(ActionTrigger at) {
        at.getCharacter().getMyLocation().setRagged(4);
        at.getCharacter().dropItem(this, null);
    }

}
