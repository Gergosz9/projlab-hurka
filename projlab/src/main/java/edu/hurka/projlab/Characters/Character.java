package edu.hurka.projlab.Characters;

import java.util.*;

import edu.hurka.projlab.Items.*;
import edu.hurka.projlab.Items.Triggers.*;
import edu.hurka.projlab.Labirinth;
import edu.hurka.projlab.Room;

/**
 * The Character class represents a character in the game.
 * It is an abstract class that provides common attributes and methods for all characters.
 * @param name the name of the character
 * @param actionCount the number of actions the character can perform in a round
 * @param paralyzed true if the character is paralyzed, false otherwise
 * @param gasResist true if the character has gas resistance, false otherwise
 * @param inventory the list of items in the character's inventory
 * @param labirinth the labirinth in which the character exists
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
        inventory = new ArrayList<Item>();
    }
    
    /**
     * Returns the character's inventory.
     * @return the character's inventory
     */
    public List<Item> getInventory(){
        return inventory;
    }

    /**
     * Uses the item at the specified index in the character's inventory.
     * If the index is 0, all items in the inventory are used with a round trigger.
     * @param index the index of the item in the inventory
     */
    public void useItem(int index){
        this.getInventory().get(index - 1).use(new ActionTrigger(this));
    }

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
        if(paralyzed){
            for(Item item : inventory){
                dropItem(item, getMyLocation());
            }
            actionCount = 0;
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
    
    /**
     * Abstract method that represents the actions to be performed in a round.
     */
    public abstract void doRound();
    
    /**
     * Method that calls the use method of all items in the character's inventory with the specified trigger.
     * @param trigger the trigger to be used
     */
    public void triggerItems(Trigger trigger){
        for(Item item : inventory){
            item.use(trigger);
        }
    }
    
    /**
     * Method that represents the action of hurting the character.
     */
    public void hurt(){}
}