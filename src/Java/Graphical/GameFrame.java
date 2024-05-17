package Java.Graphical;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
    JPanel panel;

    public GameFrame() {
        panel = new GamePanel();
        this.add(panel);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    void initGame() {

    }

    void initMenu() {

    }

}
