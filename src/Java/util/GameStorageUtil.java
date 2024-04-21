package Java.util;

import Java.Labirinth;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class GameStorageUtil {
    private static final String FILE_EXTENSION = ".json";
    private static String DIRECTORY_REPOSITORY;
    private static String DIRECTORY_SAVED_GAMES = "saved-games";


    public static void save(String name, Labirinth labirinth) {
        createRepositoryDir();

        String jsonFilePath = DIRECTORY_REPOSITORY + name + FILE_EXTENSION;
        GameSerializerUtil.saveGame(labirinth, jsonFilePath);
    }

    public static Labirinth load(String name) {
        createRepositoryDir();

        String filePath = DIRECTORY_SAVED_GAMES + File.separator + name;
        return GameSerializerUtil.loadGame(filePath);
    }

    public static List<String> getSavedGameNames() {
        File folder = new File(DIRECTORY_SAVED_GAMES + File.separator);
        File[] listOfFiles = folder.listFiles();


        return Objects.isNull(listOfFiles) ? Collections.emptyList() :
                Arrays.asList(listOfFiles).stream()
                        .filter(File::isFile)
                        .map(File::getName)
                        .collect(Collectors.toList());
    }

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
