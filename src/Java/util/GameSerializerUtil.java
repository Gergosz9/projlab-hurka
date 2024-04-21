package Java.util;

import Java.Labirinth;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;

/**
 * This classes manages how to save the actual game in json format and also how to read a saved game and convert
 * it into a valid java object
 */
public class GameSerializerUtil {
    private static Gson gson = new Gson();

    /**
     * save a game to the hard disk
     *
     * @param labyrinth actual state of the game
     * @param fileName  target file name
     */
    static void saveGame(Labirinth labyrinth, String fileName) {
        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(labyrinth, writer);
        } catch (IOException e) {
            throw new GameSavingException(e);
        }
    }

    /**
     * load a file from the hard disk
     *
     * @param fileName file name
     * @return list of moves of the stored game
     */
    static Labirinth loadGame(String fileName) {
        try (Reader reader = new FileReader(fileName)) {
            Type listType = new TypeToken<Labirinth>() {
            }.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            throw new GameLoadingException(e);
        }
    }
}
