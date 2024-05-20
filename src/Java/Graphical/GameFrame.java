package Java.Graphical;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.vecmath.Vector2d;

public class GameFrame extends JFrame {
    JPanel panel;

    public GameFrame() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initMenu();
        this.setVisible(true);
    }

    void initGame() {
        if (panel != null) {
            this.remove(panel);
        }

        panel = new GamePanel();
        this.add(panel);
        this.revalidate();
        this.repaint();
    }

    void initMenu() {
        if (panel != null) {
            this.remove(panel);
        }
        panel = new MenuPanel();

        this.add(panel);
        this.revalidate();
        this.repaint();
    }

    public static void main(String[] args) {
        new GameFrame();
    }
}
