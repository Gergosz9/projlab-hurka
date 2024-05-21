package Java.Graphical;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.vecmath.Vector2d;

public class GameFrame extends JFrame {
    JPanel panel;

    public GameFrame() {
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initMenu();
        this.setVisible(true);
    }

    public void initGame() {
        if (panel != null) {
            this.remove(panel);
        }

        panel = new GamePanel();
        this.add(panel);
        this.revalidate();
        this.repaint();
        this.pack();
    }

    void initMenu() {
        if (panel != null) {
            this.remove(panel);
        }
        panel = new MenuPanel();

        this.add(panel);
        this.revalidate();
        this.repaint();
        this.pack();
    }
}
