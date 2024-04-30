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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This classes manages how to save the actual game in json format and also how to read a saved game and convert
 * it into a valid java object
 */
public class GameSerializerUtil {
    private static Gson gson = new GsonBuilder()
            // serializers
            .registerTypeAdapter(Room.class, new RoomSerializer())
            .registerTypeAdapter(Item.class, new ItemSerializer())
            .registerTypeAdapter(Transistor.class, new TransistorSerializer())
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
            labyrinth.getRooms().stream()
                    .filter(room -> room.getTransistors() != null)
                    .flatMap(room -> room.getTransistors().stream())
                    .forEach(transistor -> {
                        transistor.setLabirinth(null);
                        if (transistor.getPair() != null) {
                            transistor.getPair().setLabirinth(null);
                        }
                    });

            gson.toJson(labyrinth, writer);

            labyrinth.getCharacters().stream()
                    .filter(Objects::nonNull)
                    .forEach(character -> character.setLabirinth(labyrinth));
            labyrinth.getRooms().stream()
                    .filter(room -> room.getTransistors() != null)
                    .flatMap(room -> room.getTransistors().stream())
                    .forEach(transistor -> {
                        transistor.setLabirinth(labyrinth);
                        if (transistor.getPair() != null) {
                            transistor.getPair().setLabirinth(labyrinth);
                        }
                    });
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

            labyrinth.getRooms().stream()
                    .filter(room -> Objects.nonNull(room.getTransistors()))
                    .flatMap(room -> room.getTransistors().stream())
                    .forEach(transistor -> transistor.setLabirinth(labyrinth));

            Map<String, Room> rooms = labyrinth.getRooms().stream()
                    .collect(Collectors.toMap(Room::getName, room -> room, (existing, replacement) -> existing));

            Map<String, Character> characters = labyrinth.getCharacters() != null ?
                    labyrinth.getCharacters().stream()
                            .collect(Collectors.toMap(Character::getName, character -> character, (existing, replacement) -> existing)) :
                    null;

            Map<String, Transistor> transistors = labyrinth.getRooms().stream()
                    .filter(room -> room.getTransistors() != null)
                    .flatMap(room -> room.getTransistors().stream())
                    .collect(Collectors.toMap(Transistor::getJsonId, transistor -> transistor, (existing, replacement) -> existing));

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

                if (!transistors.isEmpty() && room.getTransistors() != null) {
                    for (Transistor transistor : room.getTransistors()) {
                        transistor = transistors.get(transistor.getJsonId());
                        if (transistor.getPair() != null) {
                            transistor.setPair(transistors.get(transistor.getPair().getJsonId()));
                        }
                    }
                }
            });

            return labyrinth;
        } catch (IOException e) {
            throw new GameLoadingException(e);
        }
    }
}

/**
 * This class is for deserialization of Item from saved json file.
 * Implements the JsonDeserializer interface.
 * This class is required because we are using a list of derived Objects from Item.
 * In order to initialize the appropriate type having polymorphism in json frameworks (gson)
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
 * This class is required because we are using a list of derived Objects from Character.
 * In order to initialize the appropriate type having polymorphism in json frameworks (gson)
 * we need to create a custom json deserializer
 */
class CharacterDeserializer implements JsonDeserializer<Character> {
    /**
     * Takes a single json element and returns an object of a derived class of Character
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
        List<Item> inventory = context.deserialize(jsonObject.get("inventory"), new TypeToken<List<Item>>() {
        }.getType());

        switch (jsonType) {
            case "Student":
                Character student = new Student(name, null);
                student.setInventory(inventory);
                return student;
            case "Teacher":
                Character teacher = new Teacher(name, null);
                teacher.setInventory(inventory);
                return teacher;
            case "Cleaner":
                Character cleaner = new Cleaner(name, null);
                cleaner.setInventory(inventory);
                return cleaner;
            default:
                throw new JsonParseException("Unknown character type: " + jsonType);
        }
    }
}

class RoomSerializer implements JsonSerializer<Room> {
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
        // Serialize transistors
        if (rootRoom.getTransistors() != null && !rootRoom.getTransistors().isEmpty()) {
            jsonObject.add("transistors", context.serialize(rootRoom.getTransistors()));
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
                    characterObject.addProperty("teacherResist", student.isTeacherResist());
                }

                charactersArray.add(characterObject);
            }
            jsonObject.add("characters", charactersArray);
        }

        return jsonObject;
    }
}

class ItemSerializer implements JsonSerializer<Item> {
    @Override
    public JsonElement serialize(Item item, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("durability", item.getDurability());
        jsonObject.addProperty("isFake", item.isFake());
        jsonObject.addProperty("jsonType", item.getJsonType());
        return jsonObject;
    }
}

class TransistorSerializer implements JsonSerializer<Transistor> {
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
