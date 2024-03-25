package Java;

/**
 * The Teacher class represents a non-playable teacher character in the game.
 */
public class Teacher extends Character{
    
    /**
     * Constructs a Teacher object with the specified name and labirinth.
     * @param name the name of the character
     * @param labirinth the labirinth in which the character exists
     */
    public Teacher(String name, Labirinth labirinth) {
		super(name,labirinth);
    }

    /**
     * Abstract method that represents the action of moving to a different room.
     * @param room the room to move to
     */
    public void move(Room room) {
    	Room r=this.getMyLocation();
    	if(room.addTeacher(this)) {
    		r.removeTeacher(this);
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
     * Method that decides the optimal steps for the teacher during it's round.
     * @return optimalRoute the list of the rooms the teacher will go trough
     */
    List<Room> pathFind(){
        return List<Room> optimalRoute;
    }
}
