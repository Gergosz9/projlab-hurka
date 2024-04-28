package Java.Commands;
import Java.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveCommand implements Command {
    private Labirinth labirinth;

    public SaveCommand(Labirinth labirinth) {
        this.labirinth = labirinth;
    }

    @Override
    public void execute(String[] args) {

        List<Room> rooms = labirinth.getRooms();

        String fileName = args[1] + "_output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < rooms.size(); i++) {
                String output = rooms.get(i).toString();
                writer.write(output);
                writer.newLine(); //not sure kell-e
            }
            //System.out.println("A lista elemei ki lettek �rva a(z) " + fileName + " f�jlba.");
        } catch (IOException e) {
            System.err.println("Hiba t�rt�nt a f�jl �r�sa k�zben: " + e.getMessage());
        }       
    }
} //kimenti a Labirinth �llapot�t egy txt-be
