package Java.Items;

import Java.Labirinth;
import Java.Room;
import Java.Items.Triggers.*;

public class Transistor extends Item {
    private Labirinth labirinth;
    private Transistor pair;

    public Transistor(int durability, boolean isFake, Labirinth labirinth) {
        super(durability, isFake);
        pair = null;
        this.labirinth = labirinth;
    }

    public void trigger(ActionTrigger at) {
        /*
         * if (trigger == ItemTrigger.UseActiveItem) {
         * if (pair != null) {
         * for (Item item : source.getInventory()) {
         * if (item instanceof Transistor) {
         * if (item != this) {
         * Transistor transistor = (Transistor) item;
         * if (transistor.pair == null) {
         * pair((Transistor) item);
         * break;
         * }
         * }
         * }
         * }
         * } else if (getMyPairLocation() != null) {
         * source.move(getMyPairLocation());
         * } else {
         * source.getMyLocation().addTransistor(this);
         * }
         * }
         */
    }

    private boolean pair(Transistor pair) {
        if (this.pair == null && pair.pair == null) {
            this.pair = pair;
            pair.pair = this;
            return true;
        }
        return false;
    }

    private Room getMyPairLocation() {
        for (Room room : labirinth.getRooms()) {
            if (room.getTransistors().contains(pair)) {
                return room;
            }
        }
        return null;
    }
}
