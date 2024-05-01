package Java;

import java.util.*;

import Java.Characters.Character;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * The Labirinth class represents the labyrinth in the game.
 */
public class Labirinth {
    private List<Character> characters;
    private int numberOfStudents;
    private List<Room> rooms;

    /*----------------------------------------------------------------------------------------------------
     * CONSTRUCTORS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Constructs a Labirinth object with an empty list of characters and rooms.
     */
    public Labirinth() {
        characters = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    /*----------------------------------------------------------------------------------------------------
     * FUNCTIONS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Does a round of actions for all characters in the labyrinth
     */
    public void doCharactersRound() {
        for (Character character : characters) {
            character.doRound();
        }
    }

    /**
     * Updates state of rooms
     */
    public void updateRooms() {
        // Prevents change in number of rooms
        int numberOfRooms = rooms.size();
        split();
        if (numberOfRooms != rooms.size()) {
            merge();
        }

        for (Room room : rooms) {
            room.updateDoors();
            room.updateItems();
        }
    }

    /**
     * Shuffles rooms randomly,
     * selects one room to split into two, then places both in rooms
     */
    private void split() {
        Collections.shuffle(rooms);
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getOpenRooms().size() >= 2) {
                rooms.add(rooms.get(i).split());
                break;
            }
        }
    }

    /**
     * Shuffles rooms randomly,
     * selects two rooms to merge into one ()
     */
    private void merge() {
        Random random = new Random();
        Collections.shuffle(rooms);
        rooms.get(0).merge(rooms.get(0).getOpenRooms().get(random.nextInt(rooms.get(0).getOpenRooms().size())));
    }

    /**
     * Removes a character from the labyrinth
     * 
     * @param character the character to remove
     */
    public void removeCharacter(Character character) {
        characters.remove(character);
    }

    /**
     * Adds a room to the labyrinth
     * 
     * @param room the room to add
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Adds a character to the labyrinth
     * 
     * @param character the character to add
     */
    public void addCharacter(Character character) {
        characters.add(character);
    }

    /*----------------------------------------------------------------------------------------------------
     * GETTERS AND SETTERS
     *----------------------------------------------------------------------------------------------------*/

    /**
     * Returns the list of characters in the labyrinth
     * 
     * @return the list of characters
     */
    public List<Character> getCharacters() {
        return characters;
    }

    /**
     * Sets a list of characters as the contained labyrinth characters
     * 
     * @param characters the characters to set
     */
    public void setCharacters(List<Character> characters) {
        this.characters = characters;
        numberOfStudents = characters.size();
    }

    /**
     * Returns the number of students in the labyrinth
     * 
     * @return the number of students
     */
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    /**
     * Sets the number of students in the labyrinth
     * 
     * @param numberOfStudents the number of students to set
     */
    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    /**
     * Returns the list of rooms in the labyrinth
     * 
     * @return the list of rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Sets a list of rooms as the contained labyrinth rooms
     * 
     * @param rooms the rooms to set
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    /*----------------------------------------------------------------------------------------------------
    * TESTER FUNCTIONS
    *----------------------------------------------------------------------------------------------------*/

    /**
     * Converts the Labirinth object to a JSON representation.
     *
     * @return the JSON representation of the Labirinth object
     */
    public JSONObject toJSON() {
        JSONObject jsonLabirinth = new JSONObject();

        JSONArray jsonCharacters = new JSONArray();
        for (Character character : characters) {
            jsonCharacters.put(character.toJSON());
        }
        jsonLabirinth.put("characters", jsonCharacters);

        jsonLabirinth.put("numberOfStudents", numberOfStudents);

        JSONArray jsonRooms = new JSONArray();
        for (Room room : rooms) {
            jsonRooms.put(room.toJSON());
        }
        jsonLabirinth.put("rooms", jsonRooms);

        return jsonLabirinth;
    }
}
