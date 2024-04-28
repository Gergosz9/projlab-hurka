class ExaminateCommand implements Command {
    private Labirinth labirinth;

    public ExaminateCommand(Labirinth labirinth) {
        this.labirinth = labirinth;
    }

    @Override
    public void execute(String[] args) {
        // move parancs végrehajtása
        // args[1] tartalmazza a karakter nevét, args[2] pedig a cél szobát
        // A szükséges m?veletek végrehajtása a játékmenet szerint

        String fileName1 = fileNames[1] + ".txt";
        String fileName2 = fileNames[1] + "_output.txt";

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
                equal = false; // A fájlok hossza nem egyezik
            }

            if (equal) {
                //System.out.println("A fájlok tartalma megegyezik.");
            } else {
                //System.out.println("A fájlok tartalma nem egyezik.");
        }

        } catch (IOException e) {
            System.err.println("Hiba történt az összehasonlítás közben: " + e.getMessage());
        }
    }
} //összehasonlítja a kimeneti txt-t az elvárttal
