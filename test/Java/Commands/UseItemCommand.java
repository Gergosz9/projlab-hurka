package Java.Commands;

import Java.*;
import Java.Characters.Character;
import Java.Items.Item;

public class UseItemCommand implements Command {

    @Override
    public void execute(String[] args, Labirinth l) {

        Character character = getCharacterFromString(args[1], l.getCharacters());
        Item item = getItemFromString(args[2], character.getInventory());

        character.useItem(character.getInventory().indexOf(item));
    }
}