package Java.Items;

import Java.Items.Triggers.*;

public class Camembert extends Item {

    public Camembert(int durability, boolean isFake) {
        super(durability, isFake);
    }

    public void trigger(ActionTrigger at) {
        /*
         * if (trigger == ItemTrigger.UseActiveItem) {
         * durability--;
         * source.getMyLocation().setGassed(true);
         * if (durability == 0) {
         * source.dropItem(this, null); // pontosítani kell
         * }
         * }
         */
    }

}
