package Java.Graphical;

import java.util.HashMap;

import javax.imageio.ImageIO;

import java.awt.Image;
import java.io.File;

public class CharacterHash {
    public HashMap<String, Image> images;
	public CharacterHash() {
		images=new HashMap<String, Image>();
		File path=new File("rsrc/textures/characters");
		File[] files=path.listFiles();
		try {
			images.put("Cleaner", ImageIO.read(files[0]));
			images.put("Student", ImageIO.read(files[1]));
			images.put("Teacher", ImageIO.read(files[2]));
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
}
