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
        if (pair != null) {
            if (getMyPairLocation() != null)
                at.getCharacter().move(getMyPairLocation());
        } else {
            for (Item i : at.getCharacter().getInventory()) {
                if (i instanceof Transistor) {
                    Transistor t = (Transistor) i;
                    if (t.pair(this)) {
                        break;
                    }
                }
            }
        }
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
