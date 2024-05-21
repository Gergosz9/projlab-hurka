package Java;

import Java.Graphical.GameFrame;
import Java.Items.Triggers.ActionTrigger;

public class GameHandler {
	static GameFrame gameFrame;
	static Labirinth labirinth;
	static Room selectedRoom;
	static Thread gameThread;
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
		gameThread = new Thread(labirinth);
	}

	public static void startGame() {
		labirinth.generateLabirinth();
		gameFrame.initGame();
		gameThread.start();
	}

	public static void enterRoom() {
		labirinth.getCurrentPlayer().move(selectedRoom);
	}

	public static void leftRoom() {
		if (labirinth.getCurrentPlayer().getMyLocation().getOpenRooms().indexOf(selectedRoom) == 0)
			selectedRoom = labirinth.getCurrentPlayer().getMyLocation().getOpenRooms()
					.get(labirinth.getCurrentPlayer().getMyLocation().getOpenRooms().size() - 1);
		else
			selectedRoom = labirinth.getCurrentPlayer().getMyLocation().getOpenRooms()
					.get(labirinth.getCurrentPlayer().getMyLocation().getOpenRooms().indexOf(selectedRoom) - 1);
	}

	public static void rightRoom() {
		if (labirinth.getCurrentPlayer().getMyLocation().getOpenRooms()
				.indexOf(selectedRoom) == labirinth.getCurrentPlayer()
						.getMyLocation().getOpenRooms().size() - 1)
			selectedRoom = labirinth.getCurrentPlayer().getMyLocation().getOpenRooms().get(0);
		else
			selectedRoom = labirinth.getCurrentPlayer().getMyLocation().getOpenRooms()
					.get(labirinth.getCurrentPlayer().getMyLocation().getOpenRooms().indexOf(selectedRoom) + 1);
	}

	public static void endTurn() {
		labirinth.getCurrentPlayer().setActionCount(0);
	}

	public static void inventoryClick(int index, boolean drop) {
		if (labirinth.getCurrentPlayer().getInventory().size() >= index)
			return;
		if (drop)
			labirinth.getCurrentPlayer().dropItem(labirinth.getCurrentPlayer().getInventory().get(index),
					labirinth.getCurrentPlayer().getMyLocation());
		else
			labirinth.getCurrentPlayer().getInventory().get(index).use(new ActionTrigger(labirinth.getCurrentPlayer()));
	}

	public static void floorClick(int index) {
		if (labirinth.getCurrentPlayer().getMyLocation().getItems().size() < index)
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