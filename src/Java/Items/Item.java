package Java.Items;

import Java.Items.Triggers.*;

public abstract class Item {
    protected int durability;
    boolean isFake;

    protected Item(int durability, boolean isFake) {
        this.durability = durability;
        this.isFake = isFake;
    }

    public void use(Trigger trigger) {
        trigger.handle(this);
    }
}
