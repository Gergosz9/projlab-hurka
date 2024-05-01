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
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This classes manages how to save the actual game in json format and also how
 * to read a saved game and convert
 * it into a valid java object
 */
public class GameSerializerUtil {
    private static Gson gson = new GsonBuilder()
            // serializers
            .registerTypeAdapter(Room.class, new RoomSerializer())
            .registerTypeAdapter(Item.class, new ItemSerializer())
            .registerTypeAdapter(Transistor.class, new TransistorSerializer())
            .registerTypeAdapter(Character.class, new CharacterSerializer())
            // deserializers
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
        if (Objects.isNull(labyrinth)) {
            throw new GameSavingException(String.format("unable to store a null labyrinth as %s!", labyrinth));
        }

        try (Writer writer = new FileWriter(fileName)) {
            labyrinth.getCharacters().stream()
                    .filter(Objects::nonNull)
                    .forEach(character -> character.setLabirinth(null));

            gson.toJson(labyrinth, writer);

            labyrinth.getCharacters().stream()
                    .filter(Objects::nonNull)
                    .forEach(character -> character.setLabirinth(labyrinth));
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
            Type listType = new TypeToken<Labirinth>() {
            }.getType();
            Labirinth labyrinth = gson.fromJson(reader, listType);

            if (Objects.nonNull(labyrinth.getCharacters())) {
                labyrinth.getCharacters().stream()
                        .filter(Objects::nonNull)
                        .forEach(character -> character.setLabirinth(labyrinth));
            }

            Map<String, Room> rooms = labyrinth.getRooms().stream()
                    .collect(Collectors.toMap(Room::getName, room -> room, (existing, replacement) -> existing));

            Map<String, Character> characters = labyrinth.getCharacters() != null ? labyrinth.getCharacters().stream()
                    .collect(Collectors.toMap(Character::getName, character -> character,
                            (existing, replacement) -> existing))
                    : null;

            labyrinth.getRooms().forEach(room -> {
                if (room.getOpenRooms() != null) {
                    List<Room> openRooms = room.getOpenRooms().stream().map(Room::getName)
                            .map(rooms::get).collect(Collectors.toList());
                    room.setOpenRooms(openRooms);
                }
                if (room.getClosedRooms() != null) {
                    List<Room> closedRooms = room.getClosedRooms().stream().map(Room::getName)
                            .map(rooms::get).collect(Collectors.toList());
                    room.setClosedRooms(closedRooms);
                }

                if (characters != null && room.getCharacters() != null) {
                    List<Character> roomCharacters = room.getCharacters().stream().map(Character::getName)
                            .map(characters::get).collect(Collectors.toList());
                    room.setCharacters(roomCharacters);
                }

                if (room.getItems() != null) {
                    room.getItems().forEach(item -> {
                        if (item instanceof Transistor transistor) {
                            transistor.setLabirinth(labyrinth);
                        }
                    });
                }

                correctRoomArrays(room);
            });

            labyrinth.getCharacters().forEach(character -> {
                if (!character.getInventory().isEmpty()) {
                    character.getInventory().forEach(item -> {
                        if (item instanceof Transistor transistor) {
                            transistor.setLabirinth(labyrinth);
                        }
                    });
                }
            });

            return labyrinth;
        } catch (IOException e) {
            throw new GameLoadingException(e);
        }
    }

    /**
     * initalize null lists in room
     * 
     * @param room
     */
    private static void correctRoomArrays(Room room) {
        if (room.getOpenRooms() == null) {
            room.setOpenRooms(new ArrayList<>());
        }
        if (room.getClosedRooms() == null) {
            room.setClosedRooms(new ArrayList<>());
        }
        if (room.getCharacters() == null) {
            room.setCharacters(new ArrayList<>());
        }
        if (room.getItems() == null) {
            room.setItems(new ArrayList<>());
        }
    }
}

/**
 * This class is for deserialization of Item from saved json file.
 * Implements the JsonDeserializer interface.
 * This class is required because we are using a list of derived Objects from
 * Item.
 * In order to initialize the appropriate type having polymorphism in json
 * frameworks (gson)
 * we need to create a custom json deserializer
 */
class ItemDeserializer implements JsonDeserializer<Item> {
    /**
     * Takes a single json element and returns an object of a derived class of Item
     *
     * @param json    json object
     * @param typeOfT object Type
     * @param context contains context variables
     * @return an object of a derived class of an Item
     * @throws JsonParseException when format is incorrect
     */
    @Override
    public Item deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String jsonType = jsonObject.get("jsonType").getAsString();
        Integer durability = jsonObject.get("durability").getAsInt();
        Boolean isFake = jsonObject.get("isFake").getAsBoolean();

        switch (jsonType) {
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
                throw new JsonParseException("Unknown item type: " + jsonType);
        }
    }

}

/**
 * This class is for deserialization of Character from saved json file.
 * Implements the JsonDeserializer interface.
 * This class is required because we are using a list of derived Objects from
 * Character.
 * In order to initialize the appropriate type having polymorphism in json
 * frameworks (gson)
 * we need to create a custom json deserializer
 */
class CharacterDeserializer implements JsonDeserializer<Character> {
    /**
     * Takes a single json element and returns an object of a derived class of
     * Character
     *
     * @param json    json object
     * @param typeOfT object Type
     * @param context contains context variables
     * @return an object of a derived class of a Character
     * @throws JsonParseException when format is incorrect
     */
    @Override
    public Character deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String jsonType = jsonObject.get("jsonType").getAsString();
        String name = jsonObject.get("name").getAsString();

        Character character = null;

        switch (jsonType) {
            case "Student":
                character = new Student(name, null);
                ((Student) character).setTeacherResist(jsonObject.get("teacherResist").getAsBoolean());
                break;
            case "Teacher":
                character = new Teacher(name, null);
                break;
            case "Cleaner":
                character = new Cleaner(name, null);
                break;
            default:
                throw new JsonParseException("Unknown character type: " + jsonType);
        }
        List<Item> inventory = context.deserialize(jsonObject.get("inventory"), new TypeToken<List<Item>>() {
        }.getType());
        character.setActionCount(jsonObject.get("actionCount").getAsInt());
        character.setParalyzed(jsonObject.get("paralyzed").getAsBoolean());
        character.setGasResist(jsonObject.get("gasResist").getAsBoolean());
        character.setInventory(inventory);

        return character;
    }
}

/**
 * This class is for the serialization of the Character class.
 * Implements the JsonSerializer interface.
 * This class is for the correct save of Characters
 */
class CharacterSerializer implements JsonSerializer<Character> {

    /**
     * Takes a character and returns as a JsonObject
     *
     * @param character character which is serialized
     * @param type      object Type
     * @param context   contains context variables
     * @return the character as jsonObject
     */
    @Override
    public JsonElement serialize(Character character, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", character.getName());
        jsonObject.addProperty("actionCount", character.getActionCount());
        jsonObject.addProperty("gasResist", character.isGasResist());
        jsonObject.addProperty("paralyzed", character.isParalyzed());
        jsonObject.addProperty("jsonType", character.getJsonType());

        if (character instanceof Student student) {
            jsonObject.addProperty("teacherResist", student.isTeacherResist());
        }

        if (character.getInventory() != null) {
            jsonObject.add("inventory", context.serialize(character.getInventory()));
        }

        return jsonObject;
    }
}

/**
 * This class is for the serialization of the Room class.
 * Implements the JsonSerializer interface.
 * This class is needed to avoid the saving loop of the neighbouring rooms.
 */
class RoomSerializer implements JsonSerializer<Room> {
    /**
     * Takes a room and returns as a JsonObject
     *
     * @param rootRoom  room which is serialized
     * @param typeOfSrc object Type
     * @param context   contains context variables
     * @return the room as jsonObject
     */
    @Override
    public JsonElement serialize(Room rootRoom, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", rootRoom.getName());
        jsonObject.addProperty("maxCharacters", rootRoom.getMaxCharacters());
        jsonObject.addProperty("cursed", rootRoom.isCursed());
        jsonObject.addProperty("gassed", rootRoom.isGassed());
        jsonObject.addProperty("raggedRounds", rootRoom.getRaggedRounds());
        jsonObject.addProperty("stickyness", rootRoom.getStickyness());

        if (rootRoom.getClosedRooms() != null && !rootRoom.getClosedRooms().isEmpty()) {
            JsonArray closedRoomsArray = new JsonArray();
            for (Room room : rootRoom.getClosedRooms()) {
                JsonObject roomObject = new JsonObject();
                roomObject.addProperty("name", room.getName());
                closedRoomsArray.add(roomObject);
            }
            jsonObject.add("closedRooms", closedRoomsArray);
        }

        // Serialize open rooms
        if (rootRoom.getOpenRooms() != null && !rootRoom.getOpenRooms().isEmpty()) {
            JsonArray openRoomsArray = new JsonArray();
            for (Room room : rootRoom.getOpenRooms()) {
                JsonObject roomObject = new JsonObject();
                roomObject.addProperty("name", room.getName());
                openRoomsArray.add(roomObject);
            }
            jsonObject.add("openRooms", openRoomsArray);
        }
        // Serialize items
        if (rootRoom.getItems() != null && !rootRoom.getItems().isEmpty()) {
            jsonObject.add("items", context.serialize(rootRoom.getItems()));
        }

        // Serialize characters
        if (rootRoom.getCharacters() != null && !rootRoom.getCharacters().isEmpty()) {
            JsonArray charactersArray = new JsonArray();
            for (Character character : rootRoom.getCharacters()) {
                JsonObject characterObject = new JsonObject();
                characterObject.addProperty("name", character.getName());
                characterObject.addProperty("actionCount", character.getActionCount());
                characterObject.addProperty("paralyzed", character.isParalyzed());
                characterObject.addProperty("gasResist", character.isGasResist());
                characterObject.addProperty("jsonType", character.getJsonType());

                characterObject.add("inventory", context.serialize(character.getInventory()));

                // Serialize teacherResist for Students
                if (character instanceof Student student) {
                    characterObject.addProperty("teacherResist", student.getTeacherResist());
                }

                charactersArray.add(characterObject);
            }
            jsonObject.add("characters", charactersArray);
        }

        return jsonObject;
    }
}

/**
 * This class is for the serialization of the Item class.
 * Implements the JsonSerializer interface.
 * This class is needed for the manual saving of Item.
 */
class ItemSerializer implements JsonSerializer<Item> {

    /**
     * Takes an item and returns as a JsonObject
     *
     * @param item      item which is serialized
     * @param typeOfSrc object Type
     * @param context   contains context variables
     * @return the item as jsonObject
     */
    @Override
    public JsonElement serialize(Item item, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("durability", item.getDurability());
        jsonObject.addProperty("isFake", item.isFake());
        jsonObject.addProperty("jsonType", item.getJsonType());
        return jsonObject;
    }
}

/**
 * This class is for the serialization of the Transistor class.
 * Implements the JsonSerializer interface.
 * This class is needed to avoid the saving loop of the paired transistors.
 */
class TransistorSerializer implements JsonSerializer<Transistor> {
    /**
     * Takes a transistor and returns as a JsonObject
     *
     * @param transistor transistor which is serialized
     * @param typeOfSrc  object Type
     * @param context    contains context variables
     * @return the transistor as jsonObject
     */
    @Override
    public JsonElement serialize(Transistor transistor, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("durability", transistor.getDurability());
        jsonObject.addProperty("isFake", transistor.isFake());
        jsonObject.addProperty("jsonType", transistor.getJsonType());
        jsonObject.addProperty("jsonId", Integer.toHexString(System.identityHashCode(transistor)));

        if (transistor.getPair() != null) {
            JsonObject pairObject = new JsonObject();
            pairObject.addProperty("durability", transistor.getDurability());
            pairObject.addProperty("isFake", transistor.isFake());
            pairObject.addProperty("jsonType", transistor.getJsonType());
            pairObject.addProperty("jsonId", Integer.toHexString(System.identityHashCode(transistor.getPair())));
            jsonObject.add("pair", pairObject);
        }

        return jsonObject;
    }
}
