package Java.Commands;

import Java.*;
import Java.Characters.Character;

public class MoveCommand implements Command {

    @Override
    public void execute(String[] args, Labirinth l) {

        Character character = getCharacterFromString(args[1], l.getCharacters());
        Room room = getRoomFromString(args[2], l.getRooms());

        character.move(room);
    }
}
