package Java.util;

import Java.Characters.Character;
import Java.Characters.Cleaner;
import Java.Characters.Student;
import Java.Characters.Teacher;
import Java.Items.AirFreshener;
import Java.Items.Beer;
import Java.Items.Camembert;
import Java.Items.Item;
import Java.Items.Mask;
import Java.Items.Rag;
import Java.Items.SlideRule;
import Java.Items.TVSZ;
import Java.Items.Transistor;
import Java.Labirinth;
import Java.Room;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This classes manages how to save the actual game in json format and also how to read a saved game and convert
 * it into a valid java object
 * @param gson the Gson object used to serialize and deserialize the game
 */
public class GameSerializerUtil {
    private static Gson gson = new GsonBuilder()
            .registerTypeAdapter(Character.class, new CharacterDeserializer())
            .registerTypeAdapter(Item.class, new ItemDeserializer())
            .setPrettyPrinting()
            .create();

    /**
     * save a game to the hard disk
     *
     * @param labyrinth actual state of the game
     * @param fileName  target file name
     */
    static void saveGame(Labirinth labyrinth, String fileName) {
        if(Objects.isNull(labyrinth)){
            throw new GameSavingException(String.format("unable to store a null labyrinth as %s!", labyrinth));
        }

        try (Writer writer = new FileWriter(fileName)) {
            labyrinth.getCharacters().stream()
                    .filter(Objects::nonNull)
                    .forEach(character->character.setLabirinth(null));
            labyrinth.getRooms().stream()
                    .flatMap(room-> room.getTransistors().stream())
                    .forEach(transistor->transistor.setLabirinth(null));

            gson.toJson(labyrinth, writer);
            labyrinth.getCharacters().stream()
                    .filter(Objects::nonNull)
                    .forEach(character->character.setLabirinth(labyrinth));
        } catch (IOException e) {
            throw new GameSavingException(e);
        }
    }

    /**
     * load a file from the hard disk
     *
     * @param fileName file name
     * @return list of moves of the stored game
     */
    static Labirinth loadGame(String fileName) {
        try (Reader reader = new FileReader(fileName)) {
            Type listType = new TypeToken<Labirinth>() {}.getType();
            Labirinth labyrinth = gson.fromJson(reader, listType);
            labyrinth.getCharacters().stream()
                    .filter(Objects::nonNull)
                    .forEach(character->character.setLabirinth(labyrinth));
            labyrinth.getRooms().stream()
                    .flatMap(room-> room.getTransistors().stream())
                    .forEach(transistor->transistor.setLabirinth(labyrinth));

            Map<String, Room> rooms = labyrinth.getRooms().stream()
                    .collect(Collectors.toMap(Room::getName, room -> room, (existing, replacement) -> existing));
            Map<String, Character> characters = labyrinth.getCharacters().stream()
                    .collect(Collectors.toMap(Character::getName, character -> character, (existing, replacement) -> existing));

            labyrinth.getRooms().forEach(room -> {
                if(room.getOpenRooms() != null){
                    List<Room> openRooms = room.getOpenRooms().stream().map(Room::getName)
                            .map(rooms::get).collect(Collectors.toList());
                    room.setOpenRooms(openRooms);
                }
                if(room.getClosedRooms() != null){
                    List<Room> closedRooms = room.getClosedRooms().stream().map(Room::getName)
                            .map(rooms::get).collect(Collectors.toList());
                    room.setClosedRooms(closedRooms);
                }

                if(room.getCharacters() != null){
                    List<Character> roomCharacters = room.getCharacters().stream().map(Character::getName)
                            .map(characters::get).collect(Collectors.toList());
                    room.setCharacters(roomCharacters);
                }
            });

            return labyrinth;
        } catch (IOException e) {
            throw new GameLoadingException(e);
        }
    }
}

class ItemDeserializer implements JsonDeserializer<Item> {
    @Override
    public Item deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("jsonType").getAsString();
        Integer durability = jsonObject.get("durability").getAsInt();
        Boolean isFake = jsonObject.get("isFake").getAsBoolean();

        switch (type) {
            case "Transistor":
                return new Transistor(durability, isFake, null);
            case "AirFreshener":
                return new AirFreshener(durability, isFake);
            case "Beer":
                return new Beer(durability);
            case "TVSZ":
                return new TVSZ(durability);
            case "Camembert":
                return new Camembert();
            case "Mask":
                return new Mask();
            case "Rag":
                return new Rag();
            case "SlideRule":
                return new SlideRule();

            default:
                throw new JsonParseException("Unknown item type: " + type);
        }
    }

}

class CharacterDeserializer implements JsonDeserializer<Character> {
    @Override
    public Character deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("jsonType").getAsString();
        String name = jsonObject.get("name").getAsString();

        switch (type) {
            case "Student":
                return new Student(name, null);
            case "Teacher":
                return new Teacher(name, null);
            case "Cleaner":
                return new Cleaner(name, null);
            default:
                throw new JsonParseException("Unknown character type: " + type);
        }
    }

}
