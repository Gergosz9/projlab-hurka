package Java.Graphical;

import java.util.HashMap;

import javax.imageio.ImageIO;

import java.awt.Image;
import java.io.File;

public class ItemHash {
	public HashMap<String, Image> images;

	public ItemHash() {
		images = new HashMap<String, Image>();
		File path = new File("rsrc/textures/items");
		File[] files = path.listFiles();
		try {
			images.put("AirFreshener", ImageIO.read(files[0]));
			images.put("Beer", ImageIO.read(files[1]));
			images.put("Camembert", ImageIO.read(files[2]));
			images.put("Mask", ImageIO.read(files[3]));
			images.put("Rag", ImageIO.read(files[4]));
			images.put("SlideRule", ImageIO.read(files[5]));
			images.put("Transistor_Paired", ImageIO.read(files[7]));
			images.put("Transistor", ImageIO.read(files[6]));
			images.put("TVSZ", ImageIO.read(files[8]));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
