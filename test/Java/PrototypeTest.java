package Java;

import java.util.List;

import Java.Characters.*;
import Java.Items.*;
import Java.Items.Triggers.*;
import Java.util.*;

public class PrototypeTest {
    public static void main(String[] args) {
        System.out.println("Prototype Test");
    }

    static void test() {
        String gameName = "test-game-status";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("studentName", labirinth);
        Teacher teacher = new Teacher("teacherName", labirinth);
        labirinth.addCharacter(student);
        labirinth.addCharacter(teacher);

        Room closedRoom = new Room("closedRoom", 10, true, false, null, null);
        Room openRoom = new Room("openRoom", 10, true, false, null, null);
        labirinth.addRoom(closedRoom);
        labirinth.addRoom(openRoom);

        Room room = new Room("name", 10, true, false,
                List.of(closedRoom),
                List.of(openRoom));
        room.addCharacter(teacher);
        room.addCharacter(student);
        labirinth.addRoom(room);

        Room room1 = new Room("name1", 10, true, false,
                List.of(closedRoom),
                List.of(room));
        room1.addCharacter(teacher);
        labirinth.addRoom(room1);

        Room room2 = new Room("name2", 10, true, false,
                List.of(room1),
                List.of(room));
        room2.addCharacter(student);
        labirinth.addRoom(room2);

        // Items
        AirFreshener airFreshener = new AirFreshener(1, true);
        Beer beer = new Beer(3);
        Camembert camembert = new Camembert();
        Mask mask = new Mask();
        Rag rag = new Rag();
        SlideRule slideRule = new SlideRule();
        Transistor transistor = new Transistor(4, false, labirinth);
        Transistor transistor1 = new Transistor(5, true, labirinth);
        Transistor transistor2 = new Transistor(6, true, labirinth);
        Transistor transistor3 = new Transistor(7, false, labirinth);

        room.setItems(List.of(airFreshener, beer));
        room.setTransistors(List.of(transistor, transistor1));

        room1.setItems(List.of(camembert, mask));
        room1.setTransistors(List.of(transistor2));

        room2.setItems(List.of(rag, slideRule));
        room2.setTransistors(List.of(transistor3));

        GameStorageUtil.save(gameName, labirinth);
        System.out.println("Game status was SAVED");

        Labirinth loadedLabirinth = GameStorageUtil.load(gameName);
        System.out.println("\nSaved and then loaded game test status:");
        checkResult("labyrinth is not null", loadedLabirinth != null);
        checkResult("number of rooms in labyrinth", loadedLabirinth.getRooms().size() == labirinth.getRooms().size());
        for (int i = 0; i < loadedLabirinth.getRooms().size(); i++) {
            checkResult(String.format("loaded room [%d] is correct", i),
                    loadedLabirinth.getRooms().get(i).equals(labirinth.getRooms().get(i)));
        }
        checkResult("number of characters in labyrinth",
                loadedLabirinth.getCharacters().size() == labirinth.getCharacters().size());
        for (int i = 0; i < loadedLabirinth.getCharacters().size(); i++) {
            checkResult(String.format("loaded character [%d] is correct", i),
                    loadedLabirinth.getCharacters().get(i).equals(labirinth.getCharacters().get(i)));
            checkResult(String.format("loaded character [%d] contains labyrinth", i),
                    loadedLabirinth.getCharacters().get(i).getLabirinth() == loadedLabirinth);

        }

        checkResult("5th room closed room",
                loadedLabirinth.getRooms().get(4).getClosedRooms().get(0) == loadedLabirinth.getRooms().get(3));
        checkResult("5th room open room",
                loadedLabirinth.getRooms().get(4).getOpenRooms().get(0) == loadedLabirinth.getRooms().get(2));

        checkResult("3rd room 1st character",
                loadedLabirinth.getRooms().get(2).getCharacters().get(0) == loadedLabirinth.getCharacters().get(1));
        checkResult("3rd room 2nd character",
                loadedLabirinth.getRooms().get(2).getCharacters().get(1) == loadedLabirinth.getCharacters().get(0));

        checkResult("3rd room 1st item",
                loadedLabirinth.getRooms().get(2).getItems().get(0).equals(airFreshener));
        checkResult("3rd room 2nd item",
                loadedLabirinth.getRooms().get(2).getItems().get(1).equals(beer));

        checkResult("3rd room 1st transistor",
                loadedLabirinth.getRooms().get(2).getTransistors().get(0).equals(transistor));
        checkResult("3rd room 1st transistor has a labyrinth",
                loadedLabirinth.getRooms().get(2).getTransistors().get(0).getLabirinth() != null);
        checkResult("3rd room 2nd transistor",
                loadedLabirinth.getRooms().get(2).getTransistors().get(1).equals(transistor1));
        checkResult("3rd room 2nd transistor has a labyrinth",
                loadedLabirinth.getRooms().get(2).getTransistors().get(0).getLabirinth() != null);

        GameStorageUtil.deleteRepository();
    }

    static void checkResult(String criterion, boolean assertedValue) {
        String result = assertedValue ? "OK!" : "Not OK!";
        System.out.println(String.format("\t- %s: \t%s", criterion, result));
    }

}
