package Java.Characters;

import java.util.*;

import Java.*;

/**
 * The Cleaner class represents a character in the game who can clean rooms and
 * kick out other characters.
 * It extends the Character class and implements specific methods for cleaning
 * and moving.
 */
public class Cleaner extends Character {

    /*----------------------------------------------------------------------------------------------------
    * CONSTRUCTORS
    *----------------------------------------------------------------------------------------------------*/

    /**
     * Constructs a Cleaner object with the specified name and labirinth.
     * 
     * @param name      the name of the cleaner
     * @param labirinth the labirinth object representing the game board
     */
    public Cleaner(String name, Labirinth labirinth) {
        super(name, labirinth);
    }

    /*----------------------------------------------------------------------------------------------------
    * FUNCTIONS
    *----------------------------------------------------------------------------------------------------*/

    /**
     * Moves the cleaner to the specified room.
     * If the room allows the cleaner to enter, it removes the cleaner from its
     * current room and adds it to the new room.
     * Decreases the action count of the cleaner.
     * 
     * @param room the room to move to
     */
    public void move(Room room) {
        Room r = this.getMyLocation();
        if (room.addCharacter(this)) {
            r.removeCharacter(this);
            actionCount--;
        }
    }

    /**
     * Kicks out all characters from the current room and moves them to neighboring
     * rooms.
     */
    private void kickOutCharacters() {
        List<Character> characters = getMyLocation().getCharacters();
        for (Room r : getMyLocation().getRooms()) {
            for (int i = 0; i < characters.size(); i++) {
                if (r.addCharacter(characters.get(i))) {
                    getMyLocation().removeCharacter(characters.get(i));
                }
            }
        }
    }

    /**
     * Generates an optimal route for the cleaner to follow.
     * The route consists of a list of rooms, randomly selected from the neighboring
     * rooms of the current room.
     * 
     * @return the optimal route as a list of rooms
     */
    private List<Room> pathFind() {
        List<Room> optimalRoute = new ArrayList<>();
        Room currentRoom = this.getMyLocation();
        for (int i = 0; i < 6; i++) {
            optimalRoute.add(currentRoom);
            int ran = (int) (Math.random() * currentRoom.getRooms().size());
            currentRoom = currentRoom.getRooms().get(ran);
        }
        return optimalRoute;
    }

    /**
     * Performs a round of actions for the cleaner.
     * Rolls the move count, generates an optimal route, and performs the actions in
     * the route.
     * Actions include moving to a room, kicking out characters, resetting sticky
     * status, and setting gassed status.
     * Stops if the action count reaches 0.
     */
    public void doRound() {
        rollMoveCount();
        List<Room> optimalRoute = pathFind();
        for (Room r : optimalRoute) {
            move(r);
            kickOutCharacters();
            getMyLocation().resetSticky();
            getMyLocation().setGassed(false);
            if (actionCount == 0)
                break;
        }
    }

    /*----------------------------------------------------------------------------------------------------
    * TESTER FUNCTIONS
    *----------------------------------------------------------------------------------------------------*/

    /**
     * Overrides the equals method to compare two Cleaner objects for equality.
     * Cleaner objects are considered equal if they have the same name and are in
     * the same location.
     * 
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Cleaner))
            return false;
        if (!super.equals(o))
            return false;
        return super.equals(o);
    }

}
