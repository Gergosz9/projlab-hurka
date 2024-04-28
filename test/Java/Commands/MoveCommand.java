class MoveCommand implements Command {
    private Labirinth labirinth;

    public MoveCommand(Labirinth labirinth) {
        this.labirinth = labirinth;
    }

    @Override
    public void execute(String[] args) {
        // move parancs végrehajtása
        // args[1] tartalmazza a karakter nevét, args[2] pedig a cél szobát
        // A szükséges m?veletek végrehajtása a játékmenet szerint

        List<Character> characters = labirinth.getCharacters();
        Character character = getCharacterFromString(args[1], characters);

        public List<CRoom> rooms = labirinth.getRooms();
        Room room = getRoomFromString(args[2], rooms);
 
        character.move(room);
    }
}
