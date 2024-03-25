package Java;


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
    Room currentRoom = this.getMyLocation();
    if (room.addStudent(this)) {
      currentRoom.removeStudent(this);
    }
  }
  
  /**
   * Uses an item triggered by a specific event.
   * 
   * @param trigger the trigger event for using the item
   */
  public void useItem(ItemTrigger trigger, int index) {
    if(index == 0){
      for(Item item : this.getInventory()){
        item.use(trigger, this);
      }
    }
    else
      this.getInventory().get(index - 1).use(trigger, this);
  }
  
  /**
   * Called when a teacher attacks a student.
   * If the student has an item that would protect them, it uses it.
   * Otherwise, the student drops the contents of its inventory and is removed from the room's students list and the labyrinth's students list.
   * 
   * @param trigger the trigger event for using the item
   */
  public void die(ItemTrigger trigger) {
    if (trigger == ItemTrigger.TeacherAttack) {
      if (this.teacherResist) {
        for (Item item : this.getInventory()) {
          item.use(trigger, this);
        }
      } else {
        Room currentRoom = this.getMyLocation();
        int size = this.getInventory().size();
        for (int i = 0; i < size; i++) {
          this.dropItem(this.getInventory().get(0), currentRoom);
        }
        currentRoom.removeStudent(this);
        labirinth.removeStudent(this);
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
}