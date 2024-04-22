package Java.Items;

import Java.Items.Triggers.*;

public class SlideRule extends Item {

    public SlideRule(int durability, boolean isFake) {
        super(durability, isFake);
    }

    public void trigger(WinTrigger wt) {
        /*
         * if(trigger == ItemTrigger.UseActiveItem){
         * durability--;
         * 
         * if(durability == 0){
         * System.out.println("Game ends with the players victory");
         * }
         * }
         */
    }
}
