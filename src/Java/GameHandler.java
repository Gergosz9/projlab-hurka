package Java;

import Java.Graphical.GameFrame;
import Java.Items.Triggers.ActionTrigger;

public class GameHandler {
	static GameFrame gameFrame;
	static Labirinth labirinth;
	static Room selectedRoom;
	/*----------------------------------------------------------------------------------------------------
	 * CONSTRUCTORS
	 *----------------------------------------------------------------------------------------------------*/

	/*----------------------------------------------------------------------------------------------------
	* FUNCTIONS
	*----------------------------------------------------------------------------------------------------*/
	public static void main(String[] args) {
		labirinth = new Labirinth();
		labirinth.setNumberOfStudents(1);
		gameFrame = new GameFrame();
	}

	public static void startGame() {
		labirinth.generateLabirinth();
		labirinth.doCharactersRound();
		gameFrame.initGame();
	}

	public static void enterRoom() {
		labirinth.getCurrentPlayer().move(selectedRoom);
	}

	public static void leftRoom() {
		selectedRoom = labirinth.getCurrentPlayer().getMyLocation().getOpenRooms()
				.get(labirinth.getCurrentPlayer().getMyLocation().getOpenRooms().indexOf(selectedRoom) - 1);
	}

	public static void rightRoom() {
		selectedRoom = labirinth.getCurrentPlayer().getMyLocation().getOpenRooms()
				.get(labirinth.getCurrentPlayer().getMyLocation().getOpenRooms().indexOf(selectedRoom) + 1);
	}

	public static void endTurn() {
		labirinth.getCurrentPlayer().setActionCount(0);
	}

	public static void inventoryClick(int index) {
		labirinth.getCurrentPlayer().getInventory().get(index).use(new ActionTrigger(labirinth.getCurrentPlayer()));
	}

	public static void floorClick(int index) {
		labirinth.getCurrentPlayer().pickUpItem(labirinth.getCurrentPlayer().getMyLocation().getItems().get(index));
	}

	public static void increasePlayers() {
		if (labirinth.getNumberOfStudents() < 99)
			labirinth.setNumberOfStudents(labirinth.getNumberOfStudents() + 1);
		else
			labirinth.setNumberOfStudents(1);
	}

	public static void decreasePlayers() {
		if (labirinth.getNumberOfStudents() > 1)
			labirinth.setNumberOfStudents(labirinth.getNumberOfStudents() - 1);
		else
			labirinth.setNumberOfStudents(99);
	}

	/*----------------------------------------------------------------------------------------------------
	* GETTERS AND SETTERS
	*----------------------------------------------------------------------------------------------------*/
	public static Labirinth getLabirinth() {
		return labirinth;
	}
	/*----------------------------------------------------------------------------------------------------
	 * TESTER FUNCTIONS
	 *----------------------------------------------------------------------------------------------------*/
}