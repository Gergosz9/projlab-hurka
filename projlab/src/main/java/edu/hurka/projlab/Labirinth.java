package edu.hurka.projlab;

import java.util.*;

import edu.hurka.projlab.Characters.Character;

/**
 * The Labirinth class represents the labyrinth in the game.
 * @param characters the list of characters in the labyrinth
 * @param numberOfStudents the number of students in the labyrinth
 * @param rooms the list of rooms in the labyrinth
 */
public class Labirinth {
    private List<Character> characters;
    private int numberOfStudents;
    private List<Room> rooms;

    /**
     * Constructs a Labirinth object with an empty list of characters and rooms.
     */
    public Labirinth() {
        characters = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    /**
     * Returns the number of students in the labyrinth
     * @return the number of students in the labyrinth
     */
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    /**
     * Sets the number of students in the labyrinth
     * @param numberOfStudents the number of students to set
     */
    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

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
     * Returns the list of rooms in the labyrinth
     * @return the list of rooms in the labyrinth
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Returns the list of characters in the labyrinth
     * @return
     */
    public List<Character> getCharacters() {
        return characters;
    }

    /**
     * Removes a character from the labyrinth
     * @param character the character to remove
     */
    public void removeCharacter(Character character) {
        characters.remove(character);
    }
}
