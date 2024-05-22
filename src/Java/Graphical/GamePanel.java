package Java.Graphical;

import javax.swing.*;
import javax.vecmath.Vector2d;

import Java.GameHandler;

import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class GamePanel extends JPanel implements MouseListener {

    int width;
    int height;
    BufferedImage canvas;

    public GamePanel() {
        super();
        setDoubleBuffered(true);

        width = 800;
        height = 450;
        setPreferredSize(new Dimension(width, height));
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        paintHUD();
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(canvas, 0, 0, this);
    }

    public void paintRoom(List<GraphicObject> textures) {
        for (int i = 0; i < textures.size(); i++) {
            GraphicObject object = textures.get(i);
            object.size = new Vector2d(width, height);
            paint(object);
        }
    }

    public void paintInventory(List<GraphicObject> items) {
        int x = 20;
        int y = 330;
        for (int i = 0; i < items.size() && i < 8; i++) {
            GraphicObject object = items.get(i);
            object.position = new Vector2d(x, y);
            paint(object);

            if ((i + 1) % 4 == 0 && i != 0) {
                x = 20;
                y = 380;
            } else {
                x += 50;
            }
        }
    }

    public void paintCharacters(List<GraphicObject> characters) {
        int x = 300;
        int y = 150;
        for (int i = 0; i < characters.size() ; i++) {
            GraphicObject object = characters.get(i);
            object.position = new Vector2d(x, y);
            paint(object);

            x += 50;
        }
    }

    public void paintFloor(List<GraphicObject> items) {
        int x = 586;
        int y = 330;
        for (int i = 0; i < items.size() && i < 8; i++) {
            GraphicObject object = items.get(i);
            object.position = new Vector2d(x, y);
            paint(object);

            if ((i + 1) % 4 == 0 && i != 0) {
                x = 586;
                y = 380;
            } else {
                x += 50;
            }
        }
    }

    public void paintDice(int number) {
        Image diceImg = new ImageIcon("rsrc/textures/hud/die" + number + ".png").getImage();
        GraphicObject dice = new GraphicObject(new Vector2d(252, 366), new Vector2d(50, 50), diceImg);
        paint(dice);
    }

    public void paintHUD() {
        Image hudImg = new ImageIcon("rsrc/textures/hud/hud.png").getImage();
        Image endTurnImg = new ImageIcon("rsrc/textures/hud/skip.png").getImage();
        Image buttons = new ImageIcon("rsrc/textures/hud/Buttons.png").getImage();
        GraphicObject hud = new GraphicObject(new Vector2d(0, 0), new Vector2d(width, height), hudImg);
        GraphicObject endTurn = new GraphicObject(new Vector2d(340, 370), new Vector2d(200, 50), endTurnImg);
        GraphicObject button = new GraphicObject(new Vector2d(0, 0), new Vector2d(width, height), buttons);
        paint(hud);
        paint(endTurn);
        paint(button);
    }

    public void paint(GraphicObject object) {
        Graphics g = canvas.getGraphics();
        g.drawImage(object.img, (int) object.position.x, (int) object.position.y, null);
        g.dispose();
        this.repaint();
    }

    public void clear() {
        Graphics g = canvas.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        g.dispose();
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Implement as needed
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point point = e.getPoint();
        System.out.println("Mouse clicked at: " + point);

        if (point.x > 339 && point.x < 533 && point.y > 367 && point.y < 414) {
            GameHandler.endTurn();
        }

        if (point.x > 25 && point.x < 60 && point.y > 140 && point.y < 190) {
            GameHandler.leftRoom();
        }
        if (point.x > 740 && point.x < 775 && point.y > 140 && point.y < 190) {
            GameHandler.rightRoom();
        }

        if (point.x > 220 && point.x < 570 && point.y > 20 && point.y < 320)
            GameHandler.enterRoom();

        // Check if the click was on the inventory
        if (point.x > 19 && point.x < 69 && point.y > 332 && point.y < 382)
            GameHandler.inventoryClick(0, e.getButton() == MouseEvent.BUTTON3);
        if (point.x > 69 && point.x < 119 && point.y > 332 && point.y < 382)
            GameHandler.inventoryClick(1, e.getButton() == MouseEvent.BUTTON3);
        if (point.x > 119 && point.x < 169 && point.y > 332 && point.y < 382)
            GameHandler.inventoryClick(2, e.getButton() == MouseEvent.BUTTON3);
        if (point.x > 169 && point.x < 219 && point.y > 332 && point.y < 382)
            GameHandler.inventoryClick(3, e.getButton() == MouseEvent.BUTTON3);
        if (point.x > 19 && point.x < 69 && point.y > 382 && point.y < 432)
            GameHandler.inventoryClick(4, e.getButton() == MouseEvent.BUTTON3);

        // Check if the click was on the floor items
        if (point.x > 585 && point.x < 635 && point.y > 332 && point.y < 382)
            GameHandler.floorClick(0);
        if (point.x > 635 && point.x < 685 && point.y > 332 && point.y < 382)
            GameHandler.floorClick(1);
        if (point.x > 685 && point.x < 735 && point.y > 332 && point.y < 382)
            GameHandler.floorClick(2);
        if (point.x > 735 && point.x < 785 && point.y > 332 && point.y < 382)
            GameHandler.floorClick(3);
        if (point.x > 585 && point.x < 635 && point.y > 382 && point.y < 432)
            GameHandler.floorClick(4);
        if (point.x > 635 && point.x < 685 && point.y > 382 && point.y < 432)
            GameHandler.floorClick(5);
        if (point.x > 685 && point.x < 735 && point.y > 382 && point.y < 432)
            GameHandler.floorClick(6);
        if (point.x > 735 && point.x < 785 && point.y > 382 && point.y < 432)
            GameHandler.floorClick(7);
        this.clear();
        GameHandler.roomDraw();
        GameHandler.charactersDraw();
        paintHUD();
        GameHandler.diceDraw();
        GameHandler.floorItemsDraw();
        GameHandler.inventoryItemsDraw();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Implement as needed
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Implement as needed
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Implement as needed
    }
}