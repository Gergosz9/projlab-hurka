package Java.Graphical;

import java.awt.Image;

import javax.swing.*;
import javax.vecmath.Vector2d;

public class GraphicObject {

    Vector2d position;
    Vector2d size;
    Image img;

    public GraphicObject(Vector2d position, Vector2d size, Image image) {
        this.position = position;
        this.size = size;
        ImageIcon icon = new ImageIcon(image);
        this.img = icon.getImage();

        this.scaleImage(size);
    }

    void scaleImage(Vector2d size) {
        Image scaledImg = img.getScaledInstance((int) size.getX(), (int) size.getY(), Image.SCALE_FAST);
        img = new ImageIcon(scaledImg).getImage();
    }

}
