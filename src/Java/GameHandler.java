package Java;

import Java.Graphical.GameFrame;
import Java.Items.Triggers.ActionTrigger;

public class GameHandler {
	GameFrame gameFrame;
	Labirinth labirinth;
	Room selectedRoom;
	/*----------------------------------------------------------------------------------------------------
	 * CONSTRUCTORS
	 *----------------------------------------------------------------------------------------------------*/

	/*----------------------------------------------------------------------------------------------------
	* FUNCTIONS
	*----------------------------------------------------------------------------------------------------*/
	public static void main(String[] args) {
		GameFrame gameFrame = new GameFrame();
	}

	void initiate() {

	}

	void startGame() {
		labirinth = new Labirinth();
	}

	void enterRoom() {
		labirinth.getCurrentPlayer().move(selectedRoom);
	}

	void leftRoom() {
		selectedRoom = labirinth.getCurrentPlayer().getMyLocation().getOpenRooms()
				.get(labirinth.getCurrentPlayer().getMyLocation().getOpenRooms().indexOf(selectedRoom) - 1);
	}

	void rightRoom() {
		selectedRoom = labirinth.getCurrentPlayer().getMyLocation().getOpenRooms()
				.get(labirinth.getCurrentPlayer().getMyLocation().getOpenRooms().indexOf(selectedRoom) + 1);
	}

	void endTurn() {
		labirinth.getCurrentPlayer().setActionCount(0);
	}

	void inventoryClick(int index) {
		labirinth.getCurrentPlayer().getInventory().get(index).use(new ActionTrigger(labirinth.getCurrentPlayer()));
	}

	void floorClick(int index) {
		labirinth.getCurrentPlayer().pickUpItem(labirinth.getCurrentPlayer().getMyLocation().getItems().get(index));
	}

	void increasePlayers() {
		labirinth.setNumberOfStudents(labirinth.getNumberOfStudents() + 1);
	}

	void decreasePlayers() {
		labirinth.setNumberOfStudents(labirinth.getNumberOfStudents() - 1);
	}

	/*----------------------------------------------------------------------------------------------------
	* GETTERS AND SETTERS
	*----------------------------------------------------------------------------------------------------*/

	/*----------------------------------------------------------------------------------------------------
	 * TESTER FUNCTIONS
	 *----------------------------------------------------------------------------------------------------*/
}