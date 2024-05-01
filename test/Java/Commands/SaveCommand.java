package Java.Commands;

import Java.*;
import Java.util.JSONUtil;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveCommand implements Command {

    @Override
    public void execute(String[] args, Labirinth l) {
        String fileName = args[1] + "_output";

        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            try {
                // Ha nem létezik, létrehozzuk
                Files.createFile(path);
                System.out.println("File created: " + fileName);
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        try {
            JSONUtil.save(fileName, l);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
