package Java.Graphical;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.vecmath.Vector2d;

public class MenuPanel extends JPanel implements MouseListener {

    int width;
    int height;
    BufferedImage canvas;

    public MenuPanel() {
        super();
        setDoubleBuffered(true);

        width = 800;
        height = 600;
        setPreferredSize(new Dimension(width, height));
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Image backgroundImage = new ImageIcon("rsrc/textures/menu/Background.png").getImage();
        paint(new GraphicObject(new Vector2d(0, 0), new Vector2d(width, height), backgroundImage));

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
        // Implement as needed
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
