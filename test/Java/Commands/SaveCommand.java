package Java.Commands;

import Java.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SaveCommand implements Command {

    @Override
    public void execute(String[] args, Labirinth l) {
        List<Room> rooms = l.getRooms();

        String fileName = "test_resources/" + args[1] + "_output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < rooms.size(); i++) {
                String output = rooms.get(i).toString();
                writer.write(output);
                writer.newLine(); // not sure kell-e
            }
            // System.out.println("A lista elemei ki lettek �rva a(z) " + fileName + "
            // f�jlba.");
        } catch (IOException e) {
            System.err.println("Hiba t�rt�nt a f�jl �r�sa k�zben: " + e.getMessage());
        }

        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            try {
                // Ha nem létezik, létrehozzuk
                Files.createFile(path);
                System.out.println("A fájl létrehozva: " + fileName);
            } catch (IOException e) {
                System.err.println("Hiba történt a fájl létrehozása közben: " + e.getMessage());
            }
        }
    }
} // kimenti a Labirinth állapotát egy txt-be
