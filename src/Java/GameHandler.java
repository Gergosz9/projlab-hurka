package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.vecmath.Vector2d;

import Java.Graphical.CharacterHash;
import Java.Graphical.GameFrame;
import Java.Graphical.GamePanel;
import Java.Graphical.GraphicObject;
import Java.Graphical.ItemHash;
import Java.Items.Item;
import Java.Items.Transistor;
import Java.Items.Triggers.ActionTrigger;
import Java.Characters.Character;

public class GameHandler {
	static GameFrame gameFrame;
	static Labirinth labirinth;
	static Room selectedRoom;
	static Thread gameThread;
	static ItemHash itemImages = new ItemHash();
	static CharacterHash characterHash = new CharacterHash();
	static List<GraphicObject> floorItems = new ArrayList<GraphicObject>();
	static List<GraphicObject> inventoryItems = new ArrayList<GraphicObject>();
	static List<GraphicObject> charactersInRoom = new ArrayList<GraphicObject>();

	/*----------------------------------------------------------------------------------------------------
	 * CONSTRUCTORS
	 *----------------------------------------------------------------------------------------------------*/

	/*----------------------------------------------------------------------------------------------------
	* FUNCTIONS
	*----------------------------------------------------------------------------------------------------*/
	private static GraphicObject itemToGraphicObject(Item item) {
		String name = item.getClass().getSimpleName();
		if (name != "Transistor") {
			return new GraphicObject(null, new Vector2d(50, 50), itemImages.images.get(name));
		} else {
			Transistor t = (Transistor) item;
			if (t.getPair() != null) {
				return new GraphicObject(null, new Vector2d(50, 50), itemImages.images.get("Transistor_Paired"));
			} else {
				return new GraphicObject(null, new Vector2d(50, 50), itemImages.images.get(name));
			}
		}
	}

	public static void roomDraw() {
		List<GraphicObject> textures = new ArrayList<GraphicObject>();
		Random rand = new Random();
		if (labirinth.getCurrentPlayer().getMyLocation().getRaggedRounds() > 0) {
			textures.add(
					new GraphicObject(new Vector2d(0, 0), new Vector2d(800, 450),
							new ImageIcon("rsrc/textures/rooms/overlays/ragged.png").getImage()));
		}
		if (labirinth.getCurrentPlayer().getMyLocation().stickyness > 5) {
			textures.add(
					new GraphicObject(new Vector2d(0, 0), new Vector2d(800, 450),
							new ImageIcon("rsrc/textures/rooms/overlays/sticky.png").getImage()));
		}
		if (labirinth.getCurrentPlayer().getMyLocation().isGassed()) {
			textures.add(
					new GraphicObject(new Vector2d(0, 0), new Vector2d(800, 450),
							new ImageIcon("rsrc/textures/rooms/overlays/stink.png").getImage()));
		}
		textures.add(new GraphicObject(new Vector2d(0, 0), new Vector2d(800, 450),
				new ImageIcon("rsrc/textures/rooms/room1.png").getImage()));
		GamePanel gamePanel = (GamePanel) gameFrame.getPanel();
		gamePanel.paintRoom(textures);
	}

	public static void charactersDraw() {
		charactersInRoom.clear();
		List<String> names = new ArrayList<String>();
		for (Character character : labirinth.getCurrentPlayer().getMyLocation().getCharacters()) {
			String name = character.getClass().getSimpleName();
			if (!names.contains(name) && character != labirinth.getCurrentPlayer()) {
				names.add(name);
				charactersInRoom.add(new GraphicObject(null, new Vector2d(210, 330), characterHash.images.get(name)));
			}
		}
		GamePanel gamePanel = (GamePanel) gameFrame.getPanel();
		gamePanel.paintCharacters(charactersInRoom);
	}

	public static void diceDraw() {
		GamePanel gamePanel = (GamePanel) gameFrame.getPanel();
		gamePanel.paintDice(labirinth.getCurrentPlayer().getActionCount());
	}

	public static void floorItemsDraw() {
		floorItems.clear();
		for (Item item : labirinth.getCurrentPlayer().getMyLocation().getItems()) {
			floorItems.add(itemToGraphicObject(item));
		}
		GamePanel gamePanel = (GamePanel) gameFrame.getPanel();
		gamePanel.paintFloor(floorItems);
	}

	public static void inventoryItemsDraw() {
		inventoryItems.clear();
		for (Item item : labirinth.getCurrentPlayer().getInventory()) {
			inventoryItems.add(itemToGraphicObject(item));
		}
		GamePanel gamePanel = (GamePanel) gameFrame.getPanel();
		gamePanel.paintInventory(inventoryItems);
	}

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
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}

		GameHandler.roomDraw();
		GamePanel gamePanel = (GamePanel) gameFrame.getPanel();
		gamePanel.paintHUD();
		GameHandler.charactersDraw();
		GameHandler.diceDraw();
		GameHandler.floorItemsDraw();
		GameHandler.inventoryItemsDraw();
	}

	public static void enterRoom() {
		labirinth.getCurrentPlayer().move(selectedRoom);
	}

	public static void leftRoom() {
		if (selectedRoom == null) {
			selectedRoom = labirinth.getCurrentPlayer().getMyLocation().getOpenRooms().get(0);
		}
		if (labirinth.getCurrentPlayer().getMyLocation().getOpenRooms().indexOf(selectedRoom) == 0)
			selectedRoom = labirinth.getCurrentPlayer().getMyLocation().getOpenRooms()
					.get(labirinth.getCurrentPlayer().getMyLocation().getOpenRooms().size() - 1);
		else
			selectedRoom = labirinth.getCurrentPlayer().getMyLocation().getOpenRooms()
					.get(labirinth.getCurrentPlayer().getMyLocation().getOpenRooms().indexOf(selectedRoom) - 1);
		System.out.println("Left room");
	}

	public static void rightRoom() {
		if (selectedRoom == null) {
			selectedRoom = labirinth.getCurrentPlayer().getMyLocation().getOpenRooms().get(0);
		}
		if (labirinth.getCurrentPlayer().getMyLocation().getOpenRooms()
				.indexOf(selectedRoom) == labirinth.getCurrentPlayer()
						.getMyLocation().getOpenRooms().size() - 1)
			selectedRoom = labirinth.getCurrentPlayer().getMyLocation().getOpenRooms().get(0);
		else
			selectedRoom = labirinth.getCurrentPlayer().getMyLocation().getOpenRooms()
					.get(labirinth.getCurrentPlayer().getMyLocation().getOpenRooms().indexOf(selectedRoom) + 1);
		System.out.println("Right room");
	}

	public static void endTurn() {
		labirinth.getCurrentPlayer().setActionCount(0);
	}

	public static void inventoryClick(int index, boolean drop) {
		if (labirinth.getCurrentPlayer().getInventory().size() <= index)
			return;
		if (drop)
			labirinth.getCurrentPlayer().dropItem(labirinth.getCurrentPlayer().getInventory().get(index),
					labirinth.getCurrentPlayer().getMyLocation());
		else
			labirinth.getCurrentPlayer().getInventory().get(index).use(new ActionTrigger(labirinth.getCurrentPlayer()));
	}

	public static void floorClick(int index) {
		System.out.println(labirinth.getCurrentPlayer().getMyLocation().getItems().size());
		if (labirinth.getCurrentPlayer().getMyLocation().getItems().size() > index)
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