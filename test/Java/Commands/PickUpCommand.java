package Java.Commands;
import Java.*;
import Java.Characters.Character;
import Java.Items.Item;

import java.util.List;

public class PickUpCommand implements Command {
    private Labirinth labirinth;

    public PickUpCommand(Labirinth labirinth) {
        this.labirinth = labirinth;
    }

    @Override
    public void execute(String[] args) {
        
        List<Character> characters = labirinth.getCharacters();
        Character character = getCharacterFromString(args[1], characters);

        Room room = character.getMyLocation();

        List<Item> items = room.getItems();
        Item item = getItemFromString(args[2], items);

        character.pickUpItem(item);
        
    } 
}