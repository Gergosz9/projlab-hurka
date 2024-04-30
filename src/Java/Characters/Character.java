package Java.Characters;

import java.util.*;

import Java.Labirinth;
import Java.Room;
import Java.Items.*;
import Java.Items.Triggers.*;

/*
 * The Character class represents a character in the game.
 * It is an abstract class that provides common attributes and methods for all
 * characters.
 * 
 * @param name        the name of the character
 * @param actionCount the number of actions the character can perform in a round
 * @param paralyzed   true if the character is paralyzed, false otherwise
 * @param gasResist   true if the character has gas resistance, false otherwise
 * @param inventory   the list of items in the character's inventory
 * @param labirinth   the labirinth in which the character exists
 * @param jsonType    Required for the deserialization of the saved Item in json
 *                    format
 *                    because they are stored in a polymorph list which is not
 *                    supported by the json format
 */

/**
 * The Character class represents a character in the game.
 * It is an abstract class that provides common attributes and methods for all
 * characters.
 */
public abstract class Character {
    String name;
    int actionCount;
    boolean paralyzed;
    boolean gasResist;
    List<Item> inventory;
    Labirinth labirinth;
    @SuppressWarnings("unused")
    private final String jsonType;

    /**
     * Constructs a Character object with the specified name and labirinth.
     * 
     * @param name      the name of the character
     * @param labirinth the labirinth in which the character exists
     */
    public Character(String name, Labirinth labirinth) {
        this.name = name;
        this.labirinth = labirinth;
        actionCount = 0;
        paralyzed = false;
        gasResist = false;
        inventory = new ArrayList<>();

        this.jsonType = this.getClass().getSimpleName();
    }

    /**
     * Returns the character's inventory.
     * 
     * @return the character's inventory
     */
    public List<Item> getInventory() {
        return inventory;
    }

    /**
     * Uses the item at the specified index in the character's inventory.
     * If the index is 0, all items in the inventory are used with a round trigger.
     * 
     * @param index the index of the item in the inventory
     */
    public void useItem(int index) {
        this.getInventory().get(index - 1).use(new ActionTrigger(this));
    }

    /**
     * Picks up an item and adds it to the character's inventory.
     * 
     * @param item the item to be picked up
     * @return true if the item was successfully picked up, false if the inventory
     *         is full or if the room is sticky
     */
    public boolean pickUpItem(Item item) {
        if (inventory.size() <= 5 && !this.getMyLocation().isSticky()) {
            if(item instanceof Transistor transistor) {
                this.getInventory().forEach(item1 -> {
                    if(item1 instanceof Transistor transistor1 && transistor1.getPair() == null) {
                        transistor.setPair(transistor1);
                        transistor1.setPair(transistor);
                    }
                });
            }
            inventory.add(item);
            getMyLocation().removeItem(item);
            return true;
        }
        return false;
    }

    /**
     * Returns the room where the character is currently located.
     * 
     * @return the room where the character is located
     */
    public Room getMyLocation() {
        for (Room room : labirinth.getRooms()) {
            if (room.getCharacters().contains(this)) {
                return room;
            }
        }
        return null;
    }

    /**
     * Drops an item from the character's inventory and adds it to the specified
     * room.
     * 
     * @param item the item to be dropped
     * @param room the room where the item will be added
     */
    public void dropItem(Item item, Room room) {
        inventory.remove(item);
        if (room != null) {
            room.addItem(item);
        }
    }

    /**
     * Abstract method that represents the action of moving to a different room.
     * 
     * @param room the room to move to
     */
    public abstract void move(Room room);

    /**
     * Sets the paralyzed state of the character. If the character is paralyzed, all
     * items in the inventory are dropped.
     * 
     * @param paralyzed true if the character is paralyzed, false otherwise
     */
    public void setParalyzed(boolean paralyzed) {
        this.paralyzed = paralyzed;
        if (paralyzed) {
            //Error because the loop removes from inventory and it will be concurent
 //           for (Item item : inventory) {
 //               dropItem(item, getMyLocation());
 //           }
            int itemNumber = inventory.size();
            for (int i = 0; i < itemNumber; i++) {
                dropItem(inventory.get(0), getMyLocation());
            }
            actionCount = 0;
        }
    }

    /**
     * Sets the gas resistance state of the character.
     * 
     * @param gasResist true if the character has gas resistance, false otherwise
     */
    public void setGasResist(boolean gasResist) {
        this.gasResist = gasResist;
    }

    /**
     * Rolls a random number between 1 and 6 and sets it as the action count for the
     * character.
     */
    public void rollMoveCount() {
        actionCount = (int) (Math.random() * 6) + 1;
    }

    /**
     * Abstract method that represents the actions to be performed in a round.
     */
    public abstract void doRound();

    /**
     * Method that calls the use method of all items in the character's inventory
     * with the specified trigger.
     * 
     * @param trigger the trigger to be used
     */
    public void triggerItems(Trigger trigger) {
        for (Item item : inventory) {
            item.use(trigger);
        }
    }

    /**
     * Method that represents the action of hurting the character.
     */
    public void hurt() {
    }

    /**
     * Sets actionCount of Character
     * 
     * @param actionCount
     */
    public void setActionCount(int actionCount) {
        this.actionCount = actionCount;
    }

    /**
     * Sets inventory of Character
     * 
     * @param inventory
     */
    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    /**
     * Sets name of Character
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets Labirinth of Character
     * 
     * @param labirinth
     */
    public void setLabirinth(Labirinth labirinth) {
        this.labirinth = labirinth;
    }

    /**
     * Gets name of Character
     */
    public String getName() {
        return name;
    }

    /**
     * Gets labirinth of Character
     */
    public Labirinth getLabirinth() {
        return labirinth;
    }

    /**
     * Returns the actionCount of the Character
     *
     * @return the actionCount of the Character
     */
    public int getActionCount() {
        return actionCount;
    }

    /**
     *Is the Character paralyzed
     */
    public boolean isParalyzed() {
        return paralyzed;
    }

    /**
     * Does the Character resists gas
     */
    public boolean isGasResist() {
        return gasResist;
    }

    /**
     * Returns jsonType of the Character. Only used in save and load from json
     *
     * @return jsonType of the Character
     */
    public String getJsonType() {
        return jsonType;
    }

    /**
     * Compares this Character to another object
     * 
     * @param o Compared Object
     * @return boolean true if they are equal, false if they are not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Character character))
            return false;
        return actionCount == character.actionCount && paralyzed == character.paralyzed
                && gasResist == character.gasResist && Objects.equals(name, character.name);
    }

    /**
     * Hashcode of Character
     * 
     * @return Hashcode of Character
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, actionCount, paralyzed, gasResist);
    }

    /**
     * toString function of Character
     * 
     * @return toString of Character
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: ").append(name).append("\n");
        sb.append("\t\ttype: ").append(getClass().getSimpleName()).append("\n");
        sb.append("\t\tgasResist: ").append(gasResist).append("\n");
        sb.append("\t\tparalyzed: ").append(paralyzed).append("\n");
        if (this instanceof Student student) {
            sb.append("\t\tteacher resist: ").append(student.teacherResist).append("\n");
        }
        sb.append("\t\titems:\n");
        if (inventory != null) {
            for (Item item : inventory) {
                sb.append("\t\t\t").append(item).append("\n");
            }
        }
        return sb.toString();
    }
}