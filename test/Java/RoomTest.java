package Java;

import Java.Characters.Student;
import Java.Characters.Teacher;
import Java.Items.*;
import Java.util.GameStorageUtil;

import java.util.List;

public class RoomTest {
    static Labirinth labirinth = new Labirinth();
    static TestHandler testhandler = new TestHandler(labirinth);

    static void test19() {
        System.out.println("\nRagacsos szoba működése\n");
        initialize_test19();
        testhandler.processCommandFile("commands19.txt");
    }

    static void initialize_test19(){
        String gameName = "";
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
    }

}
