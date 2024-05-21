package Java.Characters;

import java.util.*;

import Java.Labirinth;
import Java.Room;
import Java.Items.Triggers.*;

/**
 * The Teacher class represents a non-playable teacher character in the game.
 */
public class Teacher extends Character {

	/*----------------------------------------------------------------------------------------------------
	* CONSTRUCTORS
	*----------------------------------------------------------------------------------------------------*/

	/**
	 * Constructs a Teacher object with the specified name and labirinth.
	 * 
	 * @param name      the name of the character
	 * @param labirinth the labirinth in which the character exists
	 */
	public Teacher(String name, Labirinth labirinth) {
		super(name, labirinth);
	}

	/*----------------------------------------------------------------------------------------------------
	* FUNCTIONS
	*----------------------------------------------------------------------------------------------------*/

	/**
	 * Method that represents the action of moving to a different room.
	 * 
	 * @param room the room to move to
	 */
	public void move(Room room) {
		Room r = this.getMyLocation();
		if (room.addCharacter(this)) {
			r.removeCharacter(this);
			if (room.isGassed() && !gasResist) {
				triggerItems(new GasTrigger(this));
				if (!gasResist)
					setParalyzed(true);
			}
			if (room.isRagged())
				setParalyzed(true);
			actionCount--;
		}
	}

	/**
	 * Method that decides the optimal steps for the teacher during it's round.
	 * 
	 * @return optimalRoute the list of the rooms the teacher will go trough
	 */
	private List<Room> pathFind() {
		List<Room> optimalRoute = new ArrayList<>();
		Room currentRoom = this.getMyLocation();
		List<Room> tree = new ArrayList<Room>();
		List<Room> parent = new ArrayList<Room>();
		List<Boolean> hasStudent = new ArrayList<Boolean>();

		List<Room> studentRooms = new ArrayList<Room>();
		for (int i = 0; i < labirinth.getNumberOfStudents(); i++) {
			studentRooms.add(labirinth.getCharacters().get(i).getMyLocation());
		}

		tree.add(currentRoom);
		parent.add(null);
		hasStudent.add(studentRooms.contains(currentRoom));
		// build the tree
		for (int i = 0; i < tree.size(); i++) {
			for (Room r : tree.get(i).getOpenRooms()) {
				if (!tree.contains(r)) {
					tree.add(r);
					parent.add(tree.get(i));
					if (studentRooms.contains(r))
						hasStudent.add(true);
					else
						hasStudent.add(false);
				}
			}
		}
		// find the optimal route
		Room destination = null;
		for (int i = 0; i < tree.size(); i++) {
			if (hasStudent.get(i)) {
				destination = tree.get(i);
				break;
			}
		}
		if (destination == null || destination == currentRoom)
			return optimalRoute;
		optimalRoute.add(destination);
		int y = tree.indexOf(destination);
		while (parent.get(y) != currentRoom) {
			optimalRoute.add(parent.get(y));
			y = tree.indexOf(parent.get(y));
		}
		Collections.reverse(optimalRoute);
		return optimalRoute;
	}

	/**
	 * Method that represents the action of the teacher during it's round.
	 */
	public void doRound() {
		rollMoveCount();
		List<Room> optimalRoute = pathFind();

		for (Room r : optimalRoute) {
			for (int i = 0; i < getMyLocation().getItems().size(); i++) {
				pickUpItem(getMyLocation().getItems().get(i));
			}
			triggerItems(new ActionTrigger(this));

			for (int i = 0; i < getInventory().size(); i++) {
				dropItem(getInventory().get(i), getMyLocation());
			}

			for (int i = 0; i < getMyLocation().getCharacters().size(); i++) {
				getMyLocation().getCharacters().get(i).hurt();
			}

			move(r);
			System.out.println("Teacher moved to " + r.getName());
			if (actionCount == 0)
				break;
		}
	}

	/*----------------------------------------------------------------------------------------------------
	* TESTER FUNCTIONS
	*----------------------------------------------------------------------------------------------------*/

	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * @param o the reference object with which to compare
	 * @return true if this object is the same as the o argument; false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Teacher))
			return false;
		if (!super.equals(o))
			return false;
		return super.equals(o);
	}
}
