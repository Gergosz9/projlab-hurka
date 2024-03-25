package Java;

import java.util.*;

import java.util.List;

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
     * Method that decides the optimal steps for the teacher during it's round.
     * @return optimalRoute the list of the rooms the teacher will go trough
     */
    public List<Room> pathFind(){
      List<Room> optimalRoute = new ArrayList<>();
       return optimalRoute;
    }
}
