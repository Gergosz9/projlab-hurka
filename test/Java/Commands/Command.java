package Java.Commands;

import Java.*;
import Java.Items.Item;
import Java.Characters.Character;

import java.util.List;

public interface Command {
    void execute(String[] args);

    public default Room getRoomFromString(String s, List<Room> rooms) {
        for (Room r : rooms) {
            if (r.getName().equals(s)) {
                return r;
            }
        }
        return null;
    }

    String[] args = new String[3];

    public default Character getCharacterFromString(String s, List<Character> characters){
        for (Character c : characters) {
            String name = c.getName();
                if (name.equals(args[1])) {
                    return c;
                }
        }
        return null;
    }

    public default Item getItemFromString(String s, List<Item> items){
        for (Item i : items) {
                if (i.getClass().getSimpleName().equals(args[1])) return i;
        }
        return null;
    }
}