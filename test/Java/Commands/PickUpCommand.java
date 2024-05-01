package Java.Commands;

import Java.*;
import Java.Characters.Character;
import Java.Items.Item;

import java.util.List;

public class PickUpCommand implements Command {

    @Override
    public void execute(String[] args, Labirinth l) {

        Character character = getCharacterFromString(args[1], l.getCharacters());

        Room room = character.getMyLocation();

        List<Item> items = room.getItems();
        Item item = getItemFromString(args[2], items);

        character.pickUpItem(item);
    }
}