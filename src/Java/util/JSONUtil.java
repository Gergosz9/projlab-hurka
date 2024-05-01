package Java.util;

import Java.*;
import org.json.*;
import java.io.*;

/**
 * The JSONUtil class provides utility methods for saving and loading Labirinth
 * objects in JSON format.
 */
public class JSONUtil {

    public static void save(String testName, Labirinth l) {
        JSONObject json = new JSONObject();
        json.put("labyrinth", l.toJSON());

        File directory = new File("projlab-hurka/rsrc/saved-games");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (FileWriter file = new FileWriter("projlab-hurka/rsrc/saved-games/" + testName + ".json")) {
            file.write(json.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
