package Java;

import java.util.List;

import Java.Characters.*;
import Java.Items.*;
import Java.util.GameStorageUtil;

/**
 * Class that contains test fuctions
 * Related to the Items
 */
public class ItemTest {
    static Labirinth labirinth = new Labirinth();
    static TestHandler testhandler = new TestHandler(labirinth);

    /**
     * Test function to testcase
     * Tranzisztor használata
     */
    public static void test01() {
        String gameName = "map01";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, false, null, null);
        r1.setOpenRooms(List.of(r2));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.getCharacters().add(student);

        Transistor t1 = new Transistor(labirinth);
        Transistor t2 = new Transistor(labirinth);

        r1.getItems().add(t1);
        r1.getItems().add(t2);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands01.txt");

    }

    /**
     * Test function to testcase 02
     * Camembert használata
     */
    public static void test02() {
        String gameName = "map02";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room room = new Room("r1", 5, false, false,
                null,
                null);
        room.getCharacters().add(student);
        labirinth.addRoom(room);

        // Items
        Mask mask = new Mask(3, false);
        Camembert camembert = new Camembert(1, false);
        student.getInventory().add(camembert);
        student.getInventory().add(mask);

        student.setGasResist(true);
        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands02.txt");
    }
    //

    /**
     * Test function to testcase 03
     * Törlőrongy használata
     */
    public static void test03() {
        String gameName = "map03";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room room = new Room("r1", 5, false, false,
                null,
                null);
        room.getCharacters().add(student);
        labirinth.addRoom(room);

        // Items
        Rag rag = new Rag(1, false);
        student.getInventory().add(rag);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands03.txt");
    }

    /**
     * Test function to testcase 04
     * Logarléc megszerzése
     */
    public static void test04() {
        String gameName = "map04";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room room = new Room("r1", 5, false, false,
                null,
                null);
        room.getCharacters().add(student);
        labirinth.addRoom(room);

        // Items
        SlideRule slideRule = new SlideRule(1, false);
        room.getItems().add(slideRule);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands04.txt");
    }

    /**
     * Test function to testcase 05
     * TVSZ használata 1
     */
    public static void test05() {
        String gameName = "map05";
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
        r1.getCharacters().add(student);
        r2.getCharacters().add(teacher);

        TVSZ tvsz = new TVSZ(3, false);
        student.getInventory().add(tvsz);
        student.setTeacherResist(true);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands05.txt");
    }

    /**
     * Test function to testcase 06
     * TVSZ használata 2
     */
    public static void test06() {
        String gameName = "map06";
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
        r1.getCharacters().add(student);
        r2.getCharacters().add(teacher);

        TVSZ tvsz = new TVSZ(3, false);
        student.getInventory().add(tvsz);
        student.setTeacherResist(false);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands06.txt");
    }

    /**
     * Test function to testcase 07
     * Söröspohár használata 1
     */
    public static void test07() {
        String gameName = "map07";
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
        r1.getCharacters().add(student);
        r2.getCharacters().add(teacher);

        Beer beer = new Beer(3, false);
        student.getInventory().add(beer);
        student.setTeacherResist(true);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands07.txt");

    }

    /**
     * Test function to testcase 08
     * Söröspohár használata 2
     */
    public static void test08() {
        String gameName = "map08";
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
        r1.getCharacters().add(student);
        r2.getCharacters().add(teacher);

        Beer beer = new Beer(3, false);
        student.getInventory().add(beer);
        student.setTeacherResist(true);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands08.txt");
    }

    //
    /**
     * Test function to testcase 09
     * Maszk használata
     */
    public static void test09() {
        String gameName = "map09";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room r1 = new Room("r1", 4, false, false, null, null);
        Room r2 = new Room("r2", 4, false, true, null, null);
        r1.setOpenRooms(List.of(r2));
        r2.setOpenRooms(List.of(r1));
        labirinth.addRoom(r1);
        labirinth.addRoom(r2);
        r1.getCharacters().add(student);

        Mask mask = new Mask(3, false);
        student.getInventory().add(mask);
        student.setTeacherResist(true);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands09.txt");

    }

    /**
     * Test function to testcase 10
     * Légtisztító használata
     */
    public static void test10() {
        String gameName = "map10";
        Labirinth labirinth = new Labirinth();

        Student student = new Student("s1", labirinth);
        labirinth.addCharacter(student);

        Room room = new Room("r1", 5, false, true,
                null,
                null);
        room.getCharacters().add(student);
        labirinth.addRoom(room);

        // Items
        AirFreshener airFreshener = new AirFreshener(1, false);
        student.getInventory().add(airFreshener);

        GameStorageUtil.save(gameName, labirinth);
        testhandler.processCommandFile("commands10.txt");
    }
}
