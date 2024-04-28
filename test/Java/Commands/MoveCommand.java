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
    public void execute(String[] args) {
        // move parancs v�grehajt�sa
        // args[1] tartalmazza a karakter nev�t, args[2] pedig a c�l szob�t
        // A sz�ks�ges m?veletek v�grehajt�sa a j�t�kmenet szerint

        List<Character> characters = labirinth.getCharacters();
        Character character = getCharacterFromString(args[1], characters);

        List<Room> rooms = labirinth.getRooms();
        Room room = getRoomFromString(args[2], rooms);
 
        character.move(room);
    }
}
