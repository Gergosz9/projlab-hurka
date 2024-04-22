package Java.Items;

import Java.Items.Triggers.*;

public class Rag extends Item {

    public Rag(int durability, boolean isFake) {
        super(durability, isFake);
    }

    public void trigger(ActionTrigger gt) {
        /*
         * if (trigger == ItemTrigger.UseActiveItem) {
         * durability--;
         * source.getMyLocation().setRagged(4);
         * if (durability == 0) {
         * source.dropItem(this, null); // pontosítani kell
         * }
         * }
         */
    }

}
