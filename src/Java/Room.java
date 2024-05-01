package Java;

import java.util.*;

import Java.Characters.Character;
import Java.Items.Item;
import Java.Items.Transistor;

/*
 * The Room class represents a room in a game.
 * Represents a room in a game.
 * @param name the name of the room
 * @param maxCharacters the maximum number of characters allowed in the room
 * @param cursed indicates if the room is cursed
 * @param gassed indicates if the room is gassed
 * @param raggedRounds the number of rounds the room stays ragged
 * @param stickyness the stickiness of the room
 * @param closedRooms the list of closed rooms connected to this room
 * @param openRooms the list of open rooms connected to this room
 * @param characters the list of characters in the room
 * @param items the list of items in the
 * @param transistors the list of transistors in the room
 */

/**
 * The Room class represents a room in a game.
 * Represents a room in a game.
 */
public class Room {
    String name;
    int maxCharacters;
    boolean cursed;
    boolean gassed;
    int raggedRounds;
    int stickyness;
    List<Room> closedRooms;
    List<Room> openRooms;
    List<Character> characters;
    List<Item> items;

    /*----------------------------------------------------------------------------------------------------
     * CONSTRUCTORS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Constructs a new Room object.
     * 
     * @param name          the name of the room
     * @param maxCharacters the maximum number of characters allowed in the room
     * @param cursed        indicates if the room is cursed
     * @param gassed        indicates if the room is gassed
     * @param closedRooms   the list of closed rooms connected to this room
     * @param openRooms     the list of open rooms connected to this room
     */
    public Room(String name, int maxCharacters, boolean cursed, boolean gassed, List<Room> closedRooms,
            List<Room> openRooms) {
        this.name = name;
        this.maxCharacters = maxCharacters;
        this.cursed = cursed;
        this.gassed = gassed;
        raggedRounds = 0;
        this.closedRooms = closedRooms;
        this.openRooms = openRooms;
        characters = new ArrayList<>();
        items = new ArrayList<>();
    }

    /*----------------------------------------------------------------------------------------------------
     * FUNCTIONS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Returns all rooms connected to this room.
     * 
     * @return a list of all rooms connected to this room
     */
    public List<Room> getRooms() {
        List<Room> rooms = new ArrayList<>();
        rooms.addAll(closedRooms);
        rooms.addAll(openRooms);
        return rooms;
    }

    /**
     * Adds a character to the room.
     * 
     * @param character the character to add
     * @return true if the character was successfully added, false if the room is
     *         full
     */
    public boolean addCharacter(Character character) {
        if (characters.size() <= maxCharacters) {
            characters.add(character);
            stickyness++;
            return true;
        }
        return false;
    }

    /**
     * Removes a character from the room.
     * 
     * @param character the character to remove
     */
    public void removeCharacter(Character character) {
        characters.remove(character);
    }

    /**
     * Adds an item to the room.
     * 
     * @param item the item to add
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes an item from the room.
     * 
     * @param item the item to remove
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Updates the number of ragged rounds in the room.
     */
    public void updateItems() {
        if (raggedRounds > 0) {
            raggedRounds--;
        }
    }

    /**
     * Updates the state of the doors in the room.
     */
    public void updateDoors() {
        if (cursed) {
            openRooms.addAll(closedRooms);
            closedRooms.clear();
            for (int i = 0; i < openRooms.size(); i++) {
                Room room = openRooms.get(i);
                if (Math.random() < 0.5) {
                    closedRooms.add(room);
                    openRooms.remove(room);
                }
            }
            if (openRooms.isEmpty())
                openRooms.add(closedRooms.remove(0));
        }
    }

    /**
     * Splits the room into two separate rooms.
     * 
     * @return the new room created after the split
     */
    public Room split() {
        Room newRoom = new Room(null, 0, false, false, new ArrayList<>(), new ArrayList<>());
        for (int i = 0; i < openRooms.size() / 2; i++) {
            newRoom.openRooms.add(openRooms.remove(0));
        }
        for (int i = 0; i < closedRooms.size() / 2; i++) {
            newRoom.closedRooms.add(closedRooms.remove(0));
        }
        for (int i = 0; i < characters.size() / 2; i++) {
            newRoom.characters.add(characters.remove(0));
        }
        for (int i = 0; i < items.size() / 2; i++) {
            newRoom.items.add(items.remove(0));
        }
        if (name.contains(" ")) {
            String[] splitName = name.split(" ");
            name = splitName[0];
            newRoom.name = splitName[1];
        } else
            newRoom.name = name + " Split"; // ????
        newRoom.raggedRounds = raggedRounds;
        newRoom.gassed = gassed;
        newRoom.cursed = cursed;
        newRoom.maxCharacters = (int) (Math.random() * maxCharacters) + 1;
        return newRoom;
    }

    /**
     * Merges another room into this room.
     * 
     * @param room the room to merge
     */
    public void merge(Room room) {
        maxCharacters = Math.max(maxCharacters, room.maxCharacters);
        cursed = cursed || room.cursed;
        gassed = gassed || room.gassed;
        raggedRounds = Math.max(raggedRounds, room.raggedRounds);
        closedRooms.addAll(room.closedRooms);
        openRooms.addAll(room.openRooms);
        characters.addAll(room.characters);
        items.addAll(room.items);
        name = name + " " + room.name;
    }

    /*----------------------------------------------------------------------------------------------------
     * GETTERS AND SETTERS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Returns the name of the room.
     *
     * @return the name of the room
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the room.
     *
     * @param name the name of the room
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the maximum number of characters allowed in the room.
     *
     * @return the maximum number of characters allowed in the room
     */
    public int getMaxCharacters() {
        return maxCharacters;
    }

    /**
     * Sets the maximum number of characters allowed in the room.
     *
     * @param maxCharacters the maximum number of characters allowed in the room
     */
    public void setMaxCharacters(int maxCharacters) {
        this.maxCharacters = maxCharacters;
    }

    /**
     * Returns whether the room is cursed or not.
     *
     * @return true if the room is cursed, false otherwise
     */
    public boolean isCursed() {
        return cursed;
    }

    /**
     * Sets whether the room is cursed or not.
     *
     * @param cursed true if the room is cursed, false otherwise
     */
    public void setCursed(boolean cursed) {
        this.cursed = cursed;
    }

    /**
     * Returns whether the room is gassed or not.
     *
     * @return true if the room is gassed, false otherwise
     */
    public boolean isGassed() {
        return gassed;
    }

    /**
     * Sets whether the room is gassed or not.
     *
     * @param gassed true if the room is gassed, false otherwise
     */
    public void setGassed(boolean gassed) {
        this.gassed = gassed;
    }

    /**
     * Returns the number of rounds the room stays ragged.
     *
     * @return the number of rounds the room stays ragged
     */
    public int getRaggedRounds() {
        return raggedRounds;
    }

    /**
     * Sets the number of rounds the room stays ragged.
     *
     * @param raggedRounds the number of rounds the room stays ragged
     */
    public void setRaggedRounds(int raggedRounds) {
        this.raggedRounds = raggedRounds;
    }

    /**
     * Returns the stickiness of the room.
     *
     * @return the stickiness of the room
     */
    public int getStickyness() {
        return stickyness;
    }

    /**
     * Sets the stickiness of the room.
     *
     * @param stickyness the stickiness of the room
     */
    public void setStickyness(int stickyness) {
        this.stickyness = stickyness;
    }

    /**
     * Returns the list of closed rooms connected to this room.
     *
     * @return the list of closed rooms connected to this room
     */
    public List<Room> getClosedRooms() {
        return closedRooms;
    }

    /**
     * Sets the list of closed rooms connected to this room.
     *
     * @param closedRooms the list of closed rooms connected to this room
     */
    public void setClosedRooms(List<Room> closedRooms) {
        this.closedRooms = closedRooms;
    }

    /**
     * Returns the list of open rooms connected to this room.
     *
     * @return the list of open rooms connected to this room
     */
    public List<Room> getOpenRooms() {
        return openRooms;
    }

    /**
     * Sets the list of open rooms connected to this room.
     *
     * @param openRooms the list of open rooms connected to this room
     */
    public void setOpenRooms(List<Room> openRooms) {
        this.openRooms = openRooms;
    }

    /**
     * Returns the list of characters in the room.
     *
     * @return the list of characters in the room
     */
    public List<Character> getCharacters() {
        return characters;
    }

    /**
     * Sets the list of characters in the room.
     *
     * @param characters the list of characters in the room
     */
    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    /**
     * Returns the list of items in the room.
     *
     * @return the list of items in the room
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Sets the list of items in the room.
     *
     * @param items the list of items in the room
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Returns the stickiness state of the room.
     * 
     * @return true if the room is sticky, false otherwise
     */
    public boolean isSticky() {
        return stickyness > 5;
    }

    /**
     * Resets the stickiness state of the room.
     */
    public void resetSticky() {
        this.stickyness = 0;
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
        if (!(o instanceof Room room))
            return false;
        return maxCharacters == room.maxCharacters && cursed == room.cursed && gassed == room.gassed
                && raggedRounds == room.raggedRounds && stickyness == room.stickyness
                && Objects.equals(name, room.name);
    }
}
