package Java;

/**
 * The Transistor class represents a transistor item in the game.
 * It extends the Item class and has the ability to pair with another
 * transistor.
 * 
 * @param labirinth the labyrinth where the transistor is located
 * @param pair      the paired transistor
 */
public class Transistor extends Item {
    private Labirinth labirinth;
    private Transistor pair;

    /**
     * Constructs a Transistor object with the specified durability.
     * 
     * @param durability the durability of the transistor
     */
    public Transistor(int durability) {
        super(durability);
        pair = null;
    }

    /**
     * Uses the transistor item based on the given trigger and source character.
     * If the trigger is UseActiveItem, it checks if there is an available pair.
     * If there is, it pairs the transistors. If not, it moves the source character
     * to the location of the paired transistor if available, otherwise it drops the
     * transistor.
     * 
     * @param trigger the trigger for using the item
     * @param source  the character using the item
     */
    public void use(ItemTrigger trigger, Character source) {
        if (trigger == ItemTrigger.UseActiveItem) {
            if (pair != null) {
                for (Item item : source.getInventory()) {
                    if (item instanceof Transistor) {
                        if (item != this) {
                            Transistor transistor = (Transistor) item;
                            if (transistor.pair == null) {
                                pair((Transistor) item);
                                break;
                            }
                        }
                    }
                }
            } else if (getMyPairLocation() != null) {
                source.move(getMyPairLocation());
            } else {
                source.dropItem(this, source.getMyLocation());
            }
        }
    }

    /**
     * Pairs the current transistor with the specified pair transistor.
     * Both transistors must not have any existing pair.
     * 
     * @param pair the transistor to pair with
     * @return true if the pairing is successful, false otherwise
     */
    private boolean pair(Transistor pair) {
        if (this.pair == null && pair.pair == null) {
            this.pair = pair;
            pair.pair = this;
            return true;
        }
        return false;
    }

    /**
     * Gets the location of the paired transistor in the labyrinth.
     * 
     * @return the room where the paired transistor is located, or null if not found
     */
    private Room getMyPairLocation() {
        for (Room room : labirinth.getRooms()) {
            if (room.getTransistors().contains(pair)) {
                return room;
            }
        }
        return null;
    }
}
