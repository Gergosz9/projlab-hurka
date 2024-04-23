package Java.util;

import Java.Labirinth;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The GameStorageUtil class provides utility methods for saving and loading game data.
 * @param FILE_EXTENSION the extension of the file where the game data is stored
 * @param DIRECTORY_REPOSITORY the directory where the saved games are stored
 * @param DIRECTORY_SAVED_GAMES the name of the directory where the saved games are stored
 */
public class GameStorageUtil {
    private static final String FILE_EXTENSION = ".json";
    private static String DIRECTORY_REPOSITORY;
    private static String DIRECTORY_SAVED_GAMES = "saved-games";

    /**
     * Saves the game data to a file with the specified name.
     *
     * @param name      the name of the file
     * @param labirinth the Labirinth object representing the game data
     */
    public static void save(String name, Labirinth labirinth) {
        createRepositoryDir();

        String jsonFilePath = DIRECTORY_REPOSITORY + name + FILE_EXTENSION;
        GameSerializerUtil.saveGame(labirinth, jsonFilePath);
    }

    /**
     * Loads the game data from a file with the specified name.
     *
     * @param name the name of the file
     * @return the Labirinth object representing the loaded game data
     */
    public static Labirinth load(String name) {
        createRepositoryDir();

        String filePath = DIRECTORY_SAVED_GAMES + File.separator + name;
        return GameSerializerUtil.loadGame(filePath);
    }

    /**
     * Retrieves a list of names of the saved games.
     *
     * @return a list of strings representing the names of the saved games
     */
    public static List<String> getSavedGameNames() {
        File folder = new File(DIRECTORY_SAVED_GAMES + File.separator);
        File[] listOfFiles = folder.listFiles();

        return Objects.isNull(listOfFiles) ? Collections.emptyList() :
                Arrays.asList(listOfFiles).stream()
                        .filter(File::isFile)
                        .map(File::getName)
                        .collect(Collectors.toList());
    }

    /**
     * Creates the repository directory if it doesn't exist.
     * The repository directory is the directory where the saved games are stored.
     * It is created in the current working directory.
     * If the directory already exists, this method does nothing.
     * If the directory cannot be created, a RepositoryCreationException is thrown.
     */
    private static void createRepositoryDir() {
        try {
            DIRECTORY_REPOSITORY = new File(".").getCanonicalPath() + File.separator + DIRECTORY_SAVED_GAMES;
            if (!new File(DIRECTORY_REPOSITORY).exists()) {
                boolean isCreated = new File(DIRECTORY_SAVED_GAMES).mkdir();
                System.out.println("repo created: " + isCreated);
            }
            DIRECTORY_REPOSITORY += File.separator;
            System.out.println("DIRECTORY_REPOSITORY: " + DIRECTORY_REPOSITORY);
        } catch (IOException e) {
            throw new RepositoryCreationException(e);
        }
    }
}
