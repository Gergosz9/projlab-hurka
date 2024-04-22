package Java.Items;

import Java.Items.Triggers.*;

public class Mask extends Item {

    public Mask(int durability, boolean isFake) {
        super(durability, isFake);
    }

    public Mask(boolean isFake) {
        super(5, isFake);
    }

    public Mask(int durability) {
        super(durability, false);
    }

    public Mask() {
        super(5, false);
    }

    public void trigger(GasTrigger gt) {
        if (gt.getCharacter().getMyLocation().isGassed()) {
            this.durability -= 1;
            gt.getCharacter().setGasResist(true);
        }
        if (this.durability <= 0) {
            gt.getCharacter().dropItem(this, null);
        }
    }
}
