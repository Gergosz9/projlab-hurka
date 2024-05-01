package Java.util;

import Java.*;
import org.json.*;
import java.io.*;

/**
 * The JSONUtil class provides utility methods for saving Labirinth
 * objects in JSON format.
 */
public class JSONUtil {

    public static void save(String testName, Labirinth l) {
        JSONObject json = new JSONObject();
        json.put("labyrinth", l.toJSON());

        try (FileWriter file = new FileWriter("saved-games/" + testName + ".json")) {
            file.write(json.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
