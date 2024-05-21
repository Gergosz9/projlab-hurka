package Java;

import java.util.*;

import Java.Characters.*;
import Java.Characters.Character;
import Java.Items.*;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * The Labirinth class represents the labyrinth in the game.
 */
public class Labirinth implements Runnable {
    private List<Character> characters;
    private int numberOfStudents;
    private List<Room> rooms;
    private Character currentPlayer;

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

    public void generateLabirinth() {
        Random random = new Random();
        for (int i = 0; i < 40; i++) {
            String name = "F" + (i + 1);
            int maxPlayers = random.nextInt(2, 6);
            boolean gassed = random.nextBoolean();
            boolean cursed = random.nextBoolean();
            rooms.add(new Room(name, maxPlayers, cursed, gassed, new ArrayList<>(), new ArrayList<>()));
        }
        ArrayList<Room> roomsCopy = new ArrayList<>(rooms);
        for (Room room : rooms) {
            Collections.shuffle(roomsCopy);
            room.getOpenRooms().add(roomsCopy.get(0));
            for (int i = 1; i < roomsCopy.size() && random.nextInt(1, (i + 2)) == 1; i++) {
                if (!room.getOpenRooms().contains(roomsCopy.get(i)) && !room.equals(roomsCopy.get(i))) {
                    room.getOpenRooms().add(roomsCopy.get(i));
                    roomsCopy.get(i).getOpenRooms().add(room);
                }
            }
        }
        placeCharacters(random);
        generateItems(random);
        updateRooms();
        for (Room room : rooms) {
            System.out.println(room.getName());
            for (Room openRoom : room.getRooms()) {
                System.out.println("  " + openRoom.getName());
            }
        }
    }

    void generateItems(Random random) {
        for (int i = 0; i < 5; i++) {
            rooms.get(random.nextInt(rooms.size())).getItems().add(new Beer(false));
            rooms.get(random.nextInt(rooms.size())).getItems().add(new AirFreshener(false));
            rooms.get(random.nextInt(rooms.size())).getItems().add(new Camembert(false));
            rooms.get(random.nextInt(rooms.size())).getItems().add(new Mask(false));
            rooms.get(random.nextInt(rooms.size())).getItems().add(new Rag(false));
            rooms.get(random.nextInt(rooms.size())).getItems().add(new Transistor(this));
            rooms.get(random.nextInt(rooms.size())).getItems().add(new TVSZ(false));

            rooms.get(random.nextInt(rooms.size())).getItems().add(new Beer(true));
            rooms.get(random.nextInt(rooms.size())).getItems().add(new AirFreshener(true));
            rooms.get(random.nextInt(rooms.size())).getItems().add(new Camembert(true));
            rooms.get(random.nextInt(rooms.size())).getItems().add(new Mask(true));
            rooms.get(random.nextInt(rooms.size())).getItems().add(new Rag(true));
            rooms.get(random.nextInt(rooms.size())).getItems().add(new Transistor(true, this));
            rooms.get(random.nextInt(rooms.size())).getItems().add(new TVSZ(true));
            rooms.get(random.nextInt(rooms.size())).getItems().add(new SlideRule(true));
        }
        rooms.get(random.nextInt(rooms.size())).getItems().add(new SlideRule(false));
    }

    void placeCharacters(Random random) {
        for (int i = 0; i < numberOfStudents; i++) {
            Student student = new Student(null, this);
            rooms.get(random.nextInt(rooms.size())).getCharacters().add(student);
            characters.add(student);
        }
        for (int i = 0; i < 2; i++) {
            Teacher teacher = new Teacher(null, this);
            Cleaner cleaner = new Cleaner(null, this);
            rooms.get(random.nextInt(rooms.size())).getCharacters().add(teacher);
            rooms.get(random.nextInt(rooms.size())).getCharacters().add(cleaner);
            characters.add(teacher);
            characters.add(cleaner);
        }
    }

    /**
     * Does a round of actions for all characters in the labyrinth
     */
    public void run() {
        while (true) {
            for (int i = 0; i < characters.size(); i++) {
                currentPlayer = characters.get(i);
                currentPlayer.doRound();
                System.out.println("Round of " + i + ". character is done.");
            }
            updateRooms();

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

    public Character getCurrentPlayer() {
        return currentPlayer;
    }

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

    public String toTXT() {
        StringBuilder txt = new StringBuilder();
        for (Room room : rooms) {
            txt.append(room.toTXT()).append("\n");
        }
        return txt.toString();
    }
}
