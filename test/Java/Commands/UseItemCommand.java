package Java.Commands;
import Java.*;

public class UseItemCommand implements Command {
    private Labirinth labirinth;

    public UseItemCommand(Labirinth labirinth) {
        this.labirinth = labirinth;
    }

    @Override
    public void execute(String[] args) {
         List<Character> characters = labirinth.getCharacters();
        Character character = getCharacterFromString(args[1], characters);

        List<Item> items = character.getInventory();
        Item item = getItemFromString(args[2], items);

        character.useItem(items.indexOf(item));
    }
}