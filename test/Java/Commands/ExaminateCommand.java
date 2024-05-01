package Java.Commands;

import Java.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExaminateCommand implements Command {
    private Labirinth labirinth;

    public ExaminateCommand(Labirinth labirinth) {

        this.labirinth = labirinth;
    }

    @Override
    public Labirinth execute(String[] args, Labirinth l) {
        this.labirinth = l;

        String fileName1 = "test_resources/" + args[1] + ".txt";
        String fileName2 = "test_resources/" + args[1] + "_output.txt";

        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
                BufferedReader reader2 = new BufferedReader(new FileReader(fileName2))) {

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            boolean equal = true;

            while (line1 != null && line2 != null) {
                System.out.println(line2);

                if (!line1.equals(line2)) {
                    equal = false;
                    System.out.println("Hiba az ezt megelőző sorban!");
                    break;
                }
                line1 = reader1.readLine();
                line2 = reader2.readLine();
            }

            /*
             * if (line1 != null || line2 != null) {
             * equal = false;
             * System.out.println("A fájlok hossza nem egyezik!");
             * }
             */

            if (equal) {
                System.out.println("A kimenet megegyezik az elvárttal, a teszt sikeres! :)!");
            } else {
                // System.out.println("A f�jlok tartalma nem egyezik.");
            }

        } catch (IOException e) {
            System.err.println("Hiba történt az összehasonlítás közben: " + e.getMessage());
        }

        return l;
    }
} // �sszehasonl�tja a kimeneti txt-t az elv�rttal
