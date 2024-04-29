package Java.Characters;

import Java.Labirinth;
import Java.Room;
import Java.Items.Item;
import Java.Items.Triggers.*;

import java.util.Objects;

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
    for (Item item : inventory)
      dropItem(item, getMyLocation());
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
    while (actionCount > 0 && !paralyzed)
      ;
  }

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
   * Returns the hash code value for this student.
   * 
   * @return the hash code value for this student
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), teacherResist);
  }
}