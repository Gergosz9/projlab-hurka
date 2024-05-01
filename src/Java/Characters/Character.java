package Java.Characters;

import java.util.*;

import Java.Labirinth;
import Java.Room;
import Java.Items.*;
import Java.Items.Triggers.*;

import org.json.*;

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

    /*----------------------------------------------------------------------------------------------------
     * CONSTRUCTORS
     *----------------------------------------------------------------------------------------------------*/

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
    }

    /*----------------------------------------------------------------------------------------------------
     * FUNCTIONS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Uses the item at the specified index in the character's inventory.
     * 
     * @param index the index of the item in the inventory
     */
    public void useItem(int index) {
        this.getInventory().get(index).use(new ActionTrigger(this));
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

    /*----------------------------------------------------------------------------------------------------
     * GETTERS AND SETTERS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Method that represents the action of hurting the character.
     */
    public void hurt() {
    }

    /**
     * Returns the name of the character.
     *
     * @return the name of the character
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the character.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the number of actions the character can perform in a round.
     *
     * @return the action count of the character
     */
    public int getActionCount() {
        return actionCount;
    }

    /**
     * Sets the number of actions the character can perform in a round.
     *
     * @param actionCount the action count to set
     */
    public void setActionCount(int actionCount) {
        this.actionCount = actionCount;
    }

    /**
     * Returns true if the character is paralyzed, false otherwise.
     *
     * @return true if the character is paralyzed, false otherwise
     */
    public boolean isParalyzed() {
        return paralyzed;
    }

    /**
     * Sets the paralyzed state of the character. If the character is paralyzed, all
     * items in the inventory are dropped.
     * 
     * @param paralyzed true if the character is paralyzed, false otherwise
     */
    public void setParalyzed(boolean paralyzed) {
        this.paralyzed = paralyzed;
        if (paralyzed) {
            for (int i = 0; i < inventory.size(); i++) {
                dropItem(inventory.get(0), getMyLocation());
            }
            actionCount = 0;
        }
    }

    /**
     * Returns true if the character has gas resistance, false otherwise.
     *
     * @return true if the character has gas resistance, false otherwise
     */
    public boolean hasGasResist() {
        return gasResist;
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
     * Returns the list of items in the character's inventory.
     *
     * @return the list of items in the character's inventory
     */
    public List<Item> getInventory() {
        return inventory;
    }

    /**
     * Sets the list of items in the character's inventory.
     *
     * @param inventory the list of items to set
     */
    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    /**
     * Returns the labirinth in which the character exists.
     *
     * @return the labirinth in which the character exists
     */
    public Labirinth getLabirinth() {
        return labirinth;
    }

    /**
     * Sets the labirinth in which the character exists.
     *
     * @param labirinth the labirinth to set
     */
    public void setLabirinth(Labirinth labirinth) {
        this.labirinth = labirinth;
    }

    /*----------------------------------------------------------------------------------------------------
     * TESTER FUNCTIONS
     *----------------------------------------------------------------------------------------------------*/

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

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("actionCount", actionCount);
        json.put("paralyzed", paralyzed);
        json.put("gasResist", gasResist);
        json.put("inventory", inventoryToJSON());
        return json;
    }

    protected JSONArray inventoryToJSON() {
        JSONArray jsonArray = new JSONArray();
        for (Item item : inventory) {
            jsonArray.put(item.toJSON());
        }
        return jsonArray;
    }
}