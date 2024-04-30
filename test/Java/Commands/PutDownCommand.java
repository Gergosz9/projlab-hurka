package Java.Commands;
import Java.*;
import Java.Characters.Character;
import Java.Items.Item;

import java.util.List;

public class PutDownCommand implements Command {
    private Labirinth labirinth;

    public PutDownCommand(Labirinth labirinth) {
        this.labirinth = labirinth;
    }

    @Override
    public Labirinth execute(String[] args, Labirinth l) {
        this.labirinth = l;
                
        List<Character> characters = labirinth.getCharacters();
        Character character = getCharacterFromString(args[1], characters);

        List<Item> items = character.getInventory();
        Item item = getItemFromString(args[2], items);

        character.dropItem(item, character.getMyLocation());
        return labirinth;
    }
}