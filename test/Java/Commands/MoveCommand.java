package Java.Commands;
import Java.*;
import Java.Characters.Character;

import java.util.List;

public class MoveCommand implements Command {
    private Labirinth labirinth;

    public MoveCommand(Labirinth labirinth) {
        this.labirinth = labirinth;
    }

    @Override
    public Labirinth execute(String[] args, Labirinth l) {
        this.labirinth = l;

        List<Character> characters = labirinth.getCharacters();
        Character character = getCharacterFromString(args[1], characters);

        List<Room> rooms = labirinth.getRooms();
        Room room = getRoomFromString(args[2], rooms);

        character.move(room);
        return labirinth;

    }
}
