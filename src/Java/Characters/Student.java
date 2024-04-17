package Java.Characters;

import Java.Labirinth;
import Java.Room;
import Java.Items.Item;
import Java.Items.Triggers.AttackTrigger;

/**
 * The Student class represents a character in the game.
 * Inherits from the Character class.
 * @param teacherResist indicates if the student has resistance to teacher attacks
 */
public class Student extends Character {
  boolean teacherResist;
  
  /**
   * Constructs a Student object with the specified name and labyrinth.
   * 
   * @param name the name of the character
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
    actionCount--;
    Room currentRoom = this.getMyLocation();
    if (room.addCharacter(this)) {
      currentRoom.removeCharacter(this);
      if(room.isGassed() && !gasResist) {
        triggerItems(new GasTrigger(this));
        if(!gasResist)
          setParalyzed(true);
      }
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

  public void hurt(){
    if(teacherResist)
      return;
    triggerItems(new AttackTrigger(this));
    if(teacherResist)
      return;
    for(Item item : inventory)
      dropItem(item, getMyLocation());
    getMyLocation().removeCharacter(this);
    labirinth.removeCharacter(this);
  }

  public void doRound(){

  }
}