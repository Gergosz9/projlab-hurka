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

        String fileName1 = args[1] + ".txt";
        String fileName2 = args[1] + "_output.txt";

        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
             BufferedReader reader2 = new BufferedReader(new FileReader(fileName2)))
        {

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            boolean equal = true;

            while (line1 != null && line2 != null) {
                if (!line1.equals(line2)) {
                    equal = false;
                    break;
                }       
                line1 = reader1.readLine();
                line2 = reader2.readLine();
            }

            if (line1 != null || line2 != null) {
                equal = false; // A f�jlok hossza nem egyezik
            }

            if (equal) {
                //System.out.println("A f�jlok tartalma megegyezik.");
            } else {
                //System.out.println("A f�jlok tartalma nem egyezik.");
        }

        } catch (IOException e) {
            System.err.println("Hiba történt az összehasonlítás közben: " + e.getMessage());
        }

        return l;
    }
} //�sszehasonl�tja a kimeneti txt-t az elv�rttal
