package Java.Items;

import Java.Items.Triggers.*;

public class Mask extends Item {

    public Mask(int durability, boolean isFake) {
        super(durability, isFake);
    }

    public void trigger(GasTrigger gt) {
        /*
         * if(trigger == ItemTrigger.GasAttack){
         * durability--;
         * source.setGasResist(true);
         * if(durability == 0){
         * source.dropItem(this, null);
         * }
         * }
         */
    }
}
