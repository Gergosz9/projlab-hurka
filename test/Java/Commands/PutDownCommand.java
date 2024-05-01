package Java.Commands;

import Java.*;
import Java.Characters.Character;
import Java.Items.Item;

import java.util.List;

public class PutDownCommand implements Command {

    @Override
    public void execute(String[] args, Labirinth l) {

        List<Character> characters = l.getCharacters();
        Character character = getCharacterFromString(args[1], characters);

        List<Item> items = character.getInventory();
        Item item = getItemFromString(args[2], items);

        character.dropItem(item, character.getMyLocation());
    }
}