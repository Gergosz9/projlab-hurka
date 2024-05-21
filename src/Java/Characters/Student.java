package Java.Characters;

import org.json.JSONObject;

import Java.Labirinth;
import Java.Room;
import Java.Items.Item;
import Java.Items.Triggers.*;

/*
 * The Student class represents a character in the game.
 * Inherits from the Character class.
 * 
 * @param teacherResist indicates if the student has resistance to teacher
 *                      attacks
 */
/**
 * The Student class represents a character in the game.
 * Inherits from the Character class.
 */
public class Student extends Character {
	boolean teacherResist;

	/*----------------------------------------------------------------------------------------------------
	* CONSTRUCTORS
	*----------------------------------------------------------------------------------------------------*/

	/**
	 * Constructs a Student object with the specified name and labyrinth.
	 * 
	 * @param name      the name of the character
	 * @param labyrinth the labyrinth in which the character exists
	 */
	public Student(String name, Labirinth labyrinth) {
		super(name, labyrinth);
		this.teacherResist = false;
	}

	/*----------------------------------------------------------------------------------------------------
	* FUNCTIONS
	*----------------------------------------------------------------------------------------------------*/

	/**
	 * Moves the student to a different room.
	 * 
	 * @param room the room to move to
	 */
	public void move(Room room) {
		Room currentRoom = this.getMyLocation();
		if (actionCount > 0 && room.addCharacter(this)) {
			currentRoom.removeCharacter(this);

			if (room.isGassed() && !gasResist) {
				triggerItems(new GasTrigger(this));

				if (!gasResist)
					setParalyzed(true);
			}
			actionCount--;
		}
	}

	/**
	 * Sets the teacher resistance of the student.
	 * 
	 * @param teacherResist the teacher resistance value to set
	 */
	public void setTeacherResist(boolean teacherResist) {
		this.teacherResist = teacherResist;
	}

	/**
	 * Sets the teacher resist
	 * 
	 * @return
	 */
	public boolean isTeacherResist() {
		return teacherResist;
	}

	/**
	 * Gets the teacher resistance of the student.
	 * 
	 * @return the teacher resistance value
	 */
	public boolean getTeacherResist() {
		return this.teacherResist;
	}

	/**
	 * Simulates the student being hurt.
	 * Drops all items in the inventory and removes the student from the labyrinth
	 * if hurt.
	 */
	public void hurt() {
		if (teacherResist)
			return;
		triggerItems(new AttackTrigger(this));
		if (teacherResist)
			return;
		for (int i = 0; i < inventory.size(); i++) {
			dropItem(inventory.get(i), getMyLocation());
		}
		getMyLocation().removeCharacter(this);
		labirinth.removeCharacter(this);
	}

	/**
	 * Performs a round of actions for the student.
	 * The student's move count is rolled, and the student continues to perform
	 * actions
	 * until the action count reaches zero or the student is paralyzed.
	 */
	public void doRound() {
		rollMoveCount();
		while (actionCount > 0 && !paralyzed) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/*----------------------------------------------------------------------------------------------------
	* TESTER FUNCTIONS
	*----------------------------------------------------------------------------------------------------*/

	/**
	 * Checks if this student is equal to another object.
	 * 
	 * @param o the object to compare
	 * @return true if the objects are equal, false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Student student))
			return false;
		if (!super.equals(o))
			return false;
		return teacherResist == student.teacherResist;
	}

	/**
	 * Converts the Student object to a JSON object
	 *
	 * @return the JSON representation of the Student object
	 */
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		json.put("type", this.getClass().getSimpleName());
		json.put("name", name);
		json.put("actionCount", actionCount);
		json.put("paralyzed", paralyzed);
		json.put("gasResist", gasResist);
		json.put("teacherResist", teacherResist);
		json.put("inventory", inventoryToJSON());
		return json;
	}

	public String toTXT(int indent) {
		StringBuilder txt = new StringBuilder();
		txt.append("Name: ").append(name).append("\n");
		indent(txt, indent);
		txt.append("type: ").append(this.getClass().getSimpleName()).append("\n");
		indent(txt, indent);
		txt.append("Action Count: ").append(actionCount).append("\n");
		indent(txt, indent);
		txt.append("paralyzed: ").append(paralyzed).append("\n");
		indent(txt, indent);
		txt.append("gasResist: ").append(gasResist).append("\n");
		indent(txt, indent);
		txt.append("teacherResist: ").append(teacherResist).append("\n");
		indent(txt, indent);
		txt.append("Inventory: ").append("\n");
		for (Item item : inventory) {
			txt.append(item.toTXT(3));
		}
		return txt.toString();
	}

	private void indent(StringBuilder sb, int indent) {
		for (int i = 0; i < indent; i++) {
			sb.append("\t");
		}
	}
}