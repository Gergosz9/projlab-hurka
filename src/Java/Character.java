package Java;

import java.util.List;

/**
 * The Character class represents a character in the game.
 * It is an abstract class that provides common attributes and methods for all characters.
 * @param name the name of the character
 * @param actionCount the number of actions the character can perform
 * @param paralyzed the paralyzed state of the character
 * @param gasResist the gas resistance state of the character
 * @param inventory the list of items in the character's inventory
 * @param labirinth the labirinth where the character is located
 */
/**
 * The abstract class representing a character in the game.
 */
public abstract class Character {
    String name;
    int actionCount;
    boolean paralyzed;
    boolean gasResist;
    List<Item> inventory;
    Labirinth labirinth;

    /**
     * Constructs a Character object with the specified name and labirinth.
     * @param name the name of the character
     * @param labirinth the labirinth in which the character exists
     */
    public Character(String name, Labirinth labirinth){
        this.name = name;
        this.labirinth = labirinth;
        actionCount = 0;
        paralyzed = false;
        gasResist = false;
    }
    
    /**
     * Returns the character's inventory.
     * @return the character's inventory
     */
    public List<Item> getInventory(){
        return inventory;
    }

    /**
     * Abstract method that represents the action of using an item triggered by a specific event.
     * @param trigger the trigger event for using the item
     */
    public abstract void useItem(ItemTrigger trigger, int index);

    /**
     * Picks up an item and adds it to the character's inventory.
     * @param item the item to be picked up
     * @return true if the item was successfully picked up, false if the inventory is full
     */
    public boolean pickUpItem(Item item){
        if(inventory.size() <= 5){
            inventory.add(item);
            return true;
        }
        return false;
    }

    /**
     * Returns the room where the character is currently located.
     * @return the room where the character is located
     */
    public Room getMyLocation(){
        for(Room room : labirinth.getRooms()){
            if(room.getCharacters().contains(this)){
                return room;
            }
        }
        return null;
    }

    /**
     * Drops an item from the character's inventory and adds it to the specified room.
     * @param item the item to be dropped
     * @param room the room where the item will be added
     */
    public void dropItem(Item item, Room room){
        inventory.remove(item);
        if(room != null){
            room.addItem(item);
        }
    }

    /**
     * Abstract method that represents the action of moving to a different room.
     * @param room the room to move to
     */
    public abstract void move(Room room);

    /**
     * Sets the paralyzed state of the character. If the character is paralyzed, all items in the inventory are dropped.
     * @param paralyzed true if the character is paralyzed, false otherwise
     */
    public void setParalyzed(boolean paralyzed){
        this.paralyzed = paralyzed;
        if(paralyzed)
            for(Item item : inventory){
                dropItem(item, getMyLocation());
            }
    }

    /**
     * Sets the gas resistance state of the character.
     * @param gasResist true if the character has gas resistance, false otherwise
     */
    public void setGasResist(boolean gasResist){
        this.gasResist = gasResist;
    }

    /**
     * Rolls a random number between 1 and 6 and sets it as the action count for the character.
     */
    public void rollMoveCount(){
        actionCount = (int)(Math.random() * 6) + 1;
    }
}
