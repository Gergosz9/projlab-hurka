package Java;

import java.util.*;

import Java.Characters.Character;
import Java.Items.Item;
import Java.Items.Transistor;

/**
 * The Room class represents a room in a game.
 * Represents a room in a game.
 * 
 * @param name          the name of the room
 * @param maxCharacters the maximum number of characters allowed in the room
 * @param cursed        indicates if the room is cursed
 * @param gassed        indicates if the room is gassed
 * @param raggedRounds  the number of rounds the room has been ragged
 * @param closedRooms   the list of closed rooms connected to this room
 * @param openRooms     the list of open rooms connected to this room
 * @param teachers      the list of teachers in the room
 * @param students      the list of students in the room
 * @param items         the list of items in the room
 * @param transistors   the list of transistors in the room
 */
public class Room {
    String name;
    int maxCharacters;
    boolean cursed;
    boolean gassed;
    int raggedRounds;
    List<Room> closedRooms;
    List<Room> openRooms;
    List<Character> characters;
    List<Item> items;
    List<Transistor> transistors;

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
        transistors = new ArrayList<>();
    }
    /**
     * Returns the number of ragged rounds in the room.
     * 
     * @return the number of ragged rounds
     */
    public boolean isRagged() {
        return raggedRounds > 0;
    }
    /**
     * Returns the number of ragged rounds in the room.
     * 
     * @return the number of ragged rounds
     */
    public boolean isGassed() {
        return gassed;
    }
    /**
     * Returns a list of all characters in the room.
     * 
     * @return a list of characters in the room
     */
    public List<Character> getCharacters() {
        return characters;
    }
    /**
     * Adds a student to the room.
     * 
     * @param student the student to add
     * @return true if the student was successfully added, false if the room is full
     */
    public boolean addCharacter(Character character) {
        if (characters.size() <= maxCharacters) {
            characters.add(character);
            return true;
        }
        return false;
    }

    /**
     * Removes a student from the room.
     * 
     * @param student the student to remove
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
     * Adds a transistor to the room.
     * 
     * @param transistor the transistor to add
     */
    public void addTransistor(Transistor transistor) {
        transistors.add(transistor);
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
     * Returns a list of all transistors in the room.
     * 
     * @return a list of transistors in the room
     */
    public List<Transistor> getTransistors() {
        return transistors;
    }

    /**
     * Updates the state of the doors in the room.
     */
    public void updateDoors() {
        if (cursed) {
            openRooms.addAll(closedRooms);
            closedRooms.clear();
            for (int i = 0; i < openRooms.size(); i++){
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
        newRoom.maxCharacters = (int) Math.random() * maxCharacters;
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
        transistors.addAll(room.transistors);
        name = name + " " + room.name;
    }

    /**
     * Sets the number of ragged rounds in the room.
     * 
     * @param raggedRounds the number of ragged rounds
     */
    public void setRagged(int raggedRounds) {
        this.raggedRounds = raggedRounds;
    }

    /**
     * Sets the gassed state of the room.
     * 
     * @param gassed the gassed state of the room
     */
    public void setGassed(boolean gassed) {
        this.gassed = gassed;
    }

    public List<Room> getOpenRooms() {
        return openRooms;
    }

    public List<Room> getClosedRooms() {
        return closedRooms;
    }

    public String getName() {
        return name;
    }
    public List<Item> getItems() {
        return items;
    }
}
