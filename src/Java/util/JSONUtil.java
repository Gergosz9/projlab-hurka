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
            file.write(json.toString(4));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void compare(JSONObject ob1, JSONObject ob2) {
        if (ob1.toString().equals(ob2.toString())) {
            System.out.println("The two JSON objects match.");
        } else {
            System.out.println("The two JSON objects do not match.");
        }
    }

    public static JSONObject load(String file) {
        JSONObject jsonObject1 = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            jsonObject1 = new JSONObject(sb.toString());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return jsonObject1;
    }

}
