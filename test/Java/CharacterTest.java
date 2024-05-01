package Java;

import java.util.List;

import Java.Characters.*;
import Java.Items.*;
import Java.util.GameStorageUtil;

/**
 * Class that contains test functions
 * Related to the Characters
 */
public class CharacterTest {

    static Labirinth labirinth = new Labirinth();
    static TestHandler testhandler = new TestHandler(labirinth);

    /**
     * Test function to testcase 11
     * Tanár összefut hallgatóval
     */
    public static void test11() {
        String gameName = "map11";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        Teacher teacher = new Teacher("t1", labirinth);
        labirinth.addCharacter(student);
        labirinth.addCharacter(teacher);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, false, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.addCharacter(student);
        r2.addCharacter(teacher);

        student.setActionCount(100);
        teacher.setActionCount(100);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("command_resources/commands11.txt");

    }

    /**
     * Test function to testcase 12
     * Hallgató összefut tanárral
     */
    public static void test12() {
        String gameName = "map12";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        Teacher teacher = new Teacher("t1", labirinth);
        labirinth.addCharacter(student);
        labirinth.addCharacter(teacher);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, false, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.addCharacter(student);
        r2.addCharacter(teacher);

        student.setActionCount(100);
        teacher.setActionCount(100);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("command_resources/commands12.txt");

    }

    /**
     * Test function to testcase 13
     * Gázos szoba maszk nélkül
     */
    public static void test13() {
        String gameName = "map13";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, true, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.addCharacter(student);
        TVSZ tvsz = new TVSZ(3, false);
        r1.addItem(tvsz);

        student.setActionCount(100);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("command_resources/commands13.txt");

    }

    /**
     * Test function to testcase 14
     * Tanár rongyos szobába lép
     */
    public static void test14() {
        String gameName = "map14";
        Labirinth labirinth = new Labirinth();

        Teacher teacher = new Teacher("t1", labirinth);
        labirinth.addCharacter(teacher);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, false, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.addCharacter(teacher);
        r2.setRagged(3);

        teacher.setActionCount(100);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("command_resources/commands14.txt");

    }

    /**
     * Test function to testcase 15
     * Karakter átlép egy másik szobába
     */
    public static void test15() {
        String gameName = "map15";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, false, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.addCharacter(student);

        student.setActionCount(100);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("command_resources/commands15.txt");

    }

    /**
     * Test function to testcase 16
     * Targy felvetele
     */
    public static void test16() {
        String gameName = "map16";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room room = new Room("r1", 5, false, false,
                null,
                null);
        room.addCharacter(student);
        labirinth.addRoom(room);

        student.setActionCount(100);

        // Items
        Rag rag = new Rag(1, true);
        room.addItem(rag);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("command_resources/commands16.txt");
    }

    /**
     * Test function to testcase 17
     * Targy letelete
     */
    public static void test17() {
        String gameName = "map17";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room room = new Room("r1", 5, false, false,
                null,
                null);
        room.addCharacter(student);
        labirinth.addRoom(room);

        student.setActionCount(100);

        // Items
        Rag rag = new Rag(1, true);
        student.pickUpItem(rag);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("command_resources/commands17.txt");
    }

    /**
     * Test function to testcase 18
     * Kitessekeles
     */
    public static void test18() {
        String gameName = "map18";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        Cleaner cleaner = new Cleaner("c1", labirinth);
        labirinth.addCharacter(student);
        labirinth.addCharacter(cleaner);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, false, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.addCharacter(cleaner);
        r2.addCharacter(student);

        student.setActionCount(100);
        cleaner.setActionCount(100);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("command_resources/commands18.txt");

    }
}
