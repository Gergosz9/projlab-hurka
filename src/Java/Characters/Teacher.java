package Java.Characters;

import java.util.*;

import java.util.List;

import Java.Labirinth;
import Java.Room;
import Java.Items.*;
import Java.Items.Triggers.*;

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
     * Method that represents the action of moving to a different room.
     * @param room the room to move to
     */
    public void move(Room room) {
    	Room r=this.getMyLocation();
    	if(room.addCharacter(this)) {
    		r.removeCharacter(this);
        if(room.isGassed() && !gasResist) {
          triggerItems(new GasTrigger(this));
          if(!gasResist)
            setParalyzed(true);
        }
        if(room.isRagged())
          setParalyzed(true);
        actionCount--;
    	}
    }

     /**
     * Method that decides the optimal steps for the teacher during it's round.
     * @return optimalRoute the list of the rooms the teacher will go trough
     */
    public List<Room> pathFind(){
      	List<Room> optimalRoute = new ArrayList<>();
     	Room currentRoom = this.getMyLocation();
     	List<Room> tree = new ArrayList<Room>();
      	List<Room> parent = new ArrayList<Room>();
      	List<Boolean> hasStudent = new ArrayList<Boolean>();
		tree.add(currentRoom);
		parent.add(null);
      	//build the tree
      	for(int i = 0; i < tree.size(); i++){
        	for(Room r : tree.get(i).getOpenRooms()){
          		if(!tree.contains(r)){
            		tree.add(r);
            		parent.add(tree.get(i));
            		if(r.getStudents().size() > 0)//FUUUUUUUCK i mean TODO
              			hasStudent.add(true);
            		else
              			hasStudent.add(false);
          		}
        	}
      	}
      	//find the optimal route
      	Room destination;
      	for(int i = 0; i < tree.size(); i++){
        	if(hasStudent.get(i)){
          		destination = tree.get(i);
          		optimalRoute.add(destination);
          		while(parent.get(i) != currentRoom){
            		optimalRoute.add(parent.get(i));
            		i = tree.indexOf(parent.get(i));
          		}
          		break;
        	}
      	}
    	optimalRoute.add(currentRoom);
      	Collections.reverse(optimalRoute);
      	return optimalRoute;
    }
    /**
     * Method that represents the action of the teacher during it's round.
     */
    public void doRound(){
    	List<Room> optimalRoute = pathFind();
    	for(Room r : optimalRoute){
        	for(Item item : getMyLocation().getItems())
        		pickUpItem(item);
        	triggerItems(new ActionTrigger(this));
        	for(Item item : getInventory())
          		dropItem(item, getMyLocation());
			for(Character c : getMyLocation().getCharacters()){
		  		c.hurt();
			}
        	move(r);
        	if(actionCount == 0)
          		break;
      	}
    }
}