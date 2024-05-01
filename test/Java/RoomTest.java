package Java;

import Java.Characters.Cleaner;

import Java.Characters.*;
import Java.Items.*;

import java.util.List;

/**
 * Class that contains test fuctions
 * Related to the Rooms
 */
public class RoomTest {

    // Ragacsos szoba működése
    public static void test19() {
        Labirinth labirinth = new Labirinth();
        TestHandler testhandler = new TestHandler(labirinth);

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);
        Room room = new Room("r1", 5, false, false,
                null,
                null);
        room.addCharacter(student);
        labirinth.addRoom(room);

        student.setActionCount(100);

        // Items
        Rag rag = new Rag(1, false);

        room.setStickyness(6);
        room.addItem(rag);

        testhandler.processCommandFile("projlab-hurka/rsrc/command_resources/commands19.txt");
    }

    // Ragacsos szoba takarítása
    public static void test20() {
        Labirinth labirinth = new Labirinth();
        TestHandler testhandler = new TestHandler(labirinth);

        Cleaner cleaner = new Cleaner("c1", labirinth);
        labirinth.addCharacter(cleaner);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, true, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.addCharacter(cleaner);

        cleaner.setActionCount(100);

        r2.setStickyness(6);

        testhandler.processCommandFile("projlab-hurka/rsrc/command_resources/commands20.txt");

    }

    // Szoba ragacsossá válik
    public static void test21() {
        Labirinth labirinth = new Labirinth();
        TestHandler testhandler = new TestHandler(labirinth);

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, true, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.addCharacter(student);

        student.setActionCount(100);

        r2.setStickyness(4);

        testhandler.processCommandFile("projlab-hurka/rsrc/command_resources/commands21.txt");

    }

    // Egy tanár találkozik több hallgatóval(egyik védve, másik nem)
    public static void test22() {
        Labirinth labirinth = new Labirinth();
        TestHandler testhandler = new TestHandler(labirinth);

        Student student = new Student("s1", labirinth);
        Student student2 = new Student("s2", labirinth);
        Teacher teacher = new Teacher("t1", labirinth);
        labirinth.addCharacter(student);
        labirinth.addCharacter(student2);
        labirinth.addCharacter(teacher);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, true, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.addCharacter(student);
        r1.addCharacter(student2);
        r2.addCharacter(teacher);
        TVSZ tvsz = new TVSZ(3, false);
        student.pickUpItem(tvsz);

        student.setActionCount(100);
        student2.setActionCount(100);
        teacher.setActionCount(100);

        testhandler.processCommandFile("projlab-hurka/rsrc/command_resources/commands22.txt");

    }

    // Egy tanár találkozik több hallgatóval(egyik védve, másik nem)
    public static void test23() {
        Labirinth labirinth = new Labirinth();
        TestHandler testhandler = new TestHandler(labirinth);

        Student student = new Student("s1", labirinth);
        Teacher teacher = new Teacher("t1", labirinth);
        Teacher teacher2 = new Teacher("t2", labirinth);
        labirinth.addCharacter(student);
        labirinth.addCharacter(teacher);
        labirinth.addCharacter(teacher2);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, true, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.addCharacter(student);
        r2.addCharacter(teacher);
        r2.addCharacter(teacher2);
        TVSZ tvsz = new TVSZ(3, false);
        student.pickUpItem(tvsz);

        student.setActionCount(100);
        teacher.setActionCount(100);
        teacher2.setActionCount(100);

        testhandler.processCommandFile("projlab-hurka/rsrc/command_resources/commands23.txt");

    }

}
