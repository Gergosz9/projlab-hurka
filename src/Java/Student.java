package Java;


/**
 * The Student class represents a character in the game.
 * @param teacherResist determines whether it can defend itself against a teacher
 */
public class Student extends Character{
    boolean teacherResist;
    
    /**
     * Constructs a Student object with the specified name and labirinth.
     * @param name the name of the character
     * @param labirinth the labirinth in which the character exists
     */
    public Student(String name, Labirinth labirinth) {
		super(name,labirinth);
		this.teacherResist=false;
    }
    /**
     * Abstract method that represents the action of moving to a different room.
     * @param room the room to move to
     */
    public void move(Room room) {
    	Room r=this.getMyLocation();
    	if(room.addStudent(this)) {
    		r.removeStudent(this);
    	}
    }
    /**
     * Abstract method that represents the action of using an item triggered by a specific event.
     * @param trigger the trigger event for using the item
     */
    public void useItem(ItemTrigger trigger) {
    	for(int i=0;i<this.getInventory().size(); i++) {
    		this.getInventory().get(i).use(trigger,this);
    	}
    }
    /**
     * Method thats called when a teacher attacks a student.
     * If the student has an item that would protect him it uses it, otherwise the student drops the content of its inventory
     * and is removed from the rooms students list and the labirinths students list
     * @param trigger the trigger event for using the item
     */
    public void die(ItemTrigger trigger) {
    	if(trigger==ItemTrigger.TeacherAttack) {
    		if(this.teacherResist) {
    			int size=this.getInventory().size();
    			this.useItem(trigger);
    		}
    		else {
    			Room r=this.getMyLocation();
    			int size=this.getInventory().size();
    			for(int i=0;i<size;i++) {
    				this.dropitem(this.getInventory().get(0),r);
    			}
    			r.removeStudent(this);
    			labirinth.removeStudent(this);
    		}
    	}
    }

}