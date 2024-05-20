package Java.Graphical;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
    JPanel panel;

    public GameFrame() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        initMenu();
    }

    void initGame() {
        panel = new GamePanel();
    }

    void initMenu() {
        panel = new MenuPanel();
        this.add(panel);
    }

}