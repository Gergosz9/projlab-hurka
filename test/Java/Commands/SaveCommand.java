class SaveCommand implements Command {
    private Labirinth labirinth;

    public SaveCommand(Labirinth labirinth) {
        this.labirinth = labirinth;
    }

    @Override
    public void execute(String[] args) {

        public List<CRoom> rooms = labirinth.getRooms();

        String fileName = arg + "_output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < rooms.size(); i++) {
                String output = rooms.get(i).toString();
                writer.write(output);
                writer.newLine(); //not sure kell-e
            }
            //System.out.println("A lista elemei ki lettek írva a(z) " + fileName + " fájlba.");
        } catch (IOException e) {
            System.err.println("Hiba történt a fájl írása közben: " + e.getMessage());
        }       
    }
} //kimenti a Labirinth állapotát egy txt-be
