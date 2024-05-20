package Java.Graphical;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.vecmath.Vector2d;

import Java.GameHandler;

public class MenuPanel extends JPanel implements MouseListener {

    int width;
    int height;
    BufferedImage canvas;
    JLabel playersNumber;

    public MenuPanel() {
        super();
        setDoubleBuffered(true);
        this.setLayout(null);

        width = 800;
        height = 450;
        setPreferredSize(new Dimension(width, height));
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Image backgroundImage = new ImageIcon("rsrc/textures/menu/Background.png").getImage();
        paint(new GraphicObject(new Vector2d(0, 0), new Vector2d(width, height), backgroundImage));

        Image foreGroundImage = new ImageIcon("rsrc/textures/menu/Text.png").getImage();
        paint(new GraphicObject(new Vector2d(0, 0), new Vector2d(width, height), foreGroundImage));

        playersNumber = new JLabel("1");
        playersNumber.setForeground(Color.WHITE);
        playersNumber.setFont(new Font("Arial", Font.BOLD, 60));
        playersNumber.setBounds(393, 282, 100, 60);
        this.add(playersNumber);

        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(canvas, 0, 0, this);
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
        Point p = e.getPoint();
        System.out.println(p);
        if (p.x > 319 && p.x < 356 && p.y > 294 && p.y < 331) {
            GameHandler.decreasePlayers();
            playersNumber.setText(Integer.toString(GameHandler.getLabirinth().getNumberOfStudents()));
        }
        if (p.x > 463 && p.x < 507 && p.y > 294 && p.y < 331) {
            GameHandler.increasePlayers();
            playersNumber.setText(Integer.toString(GameHandler.getLabirinth().getNumberOfStudents()));
        }
        if (p.x > 349 && p.x < 479 && p.y > 368 && p.y < 396) {
            GameHandler.startGame();
        }
        if (GameHandler.getLabirinth().getNumberOfStudents() > 9) {
            playersNumber.setBounds(376, 282, 100, 60);
        } else {
            playersNumber.setBounds(393, 282, 100, 60);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Implement as needed
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
